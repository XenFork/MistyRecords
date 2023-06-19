package union.xenfork.misty.records.states;

import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;

import java.util.HashMap;
import java.util.UUID;

import static union.xenfork.misty.records.MistyRecords.modid;

public class CapacityState extends PersistentState {
    public HashMap<UUID, PlayerState> players = new HashMap<>();

    public static PlayerState getPlayerState(LivingEntity player) {
        CapacityState capacityState = getCapacityState(player.getWorld().getServer());
        return capacityState.players.computeIfAbsent(player.getUuid(), uuid -> new PlayerState());
    }

    public static CapacityState getCapacityState(MinecraftServer server) {
        PersistentStateManager persistentStateManager = server.getOverworld().getPersistentStateManager();
        return persistentStateManager.getOrCreate(
                CapacityState::create,
                CapacityState::new,
                modid
        );
    }

    public static CapacityState create(NbtCompound nbt) {
        CapacityState capacityState = new CapacityState();
        NbtCompound attribute = nbt.getCompound("misty_attribute");
        attribute.getKeys().forEach(key -> {
            PlayerState playerState = new PlayerState();
            playerState.strength = attribute.getCompound(key).getDouble("strength");
            playerState.aura = attribute.getCompound(key).getDouble("aura");
            playerState.defense = attribute.getCompound(key).getDouble("defense");
            playerState.blood = attribute.getCompound(key).getDouble("blood");
            playerState.criticalHit = attribute.getCompound(key).getDouble("criticalHit");
            playerState.criticalDamage = attribute.getCompound(key).getDouble("criticalDamage");
            playerState.speed = attribute.getCompound(key).getDouble("speed");
            playerState.endurance = attribute.getCompound(key).getDouble("endurance");
            playerState.potential = attribute.getCompound(key).getDouble("potential");
            playerState.hit = attribute.getCompound(key).getDouble("hit");
            playerState.dodge = attribute.getCompound(key).getDouble("dodge");
            UUID uuid = UUID.fromString(key);
            capacityState.players.put(uuid, playerState);
        });
        return capacityState;
    }
    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        NbtCompound playersNbt = new NbtCompound();
        players.forEach((uuid, playerState) -> {
            NbtCompound playerDataAsNbt = new NbtCompound();
            playerDataAsNbt.putDouble("strength", playerState.strength);
            playerDataAsNbt.putDouble("aura", playerState.aura);
            playerDataAsNbt.putDouble("defense", playerState.defense);
            playerDataAsNbt.putDouble("blood", playerState.blood);
            playerDataAsNbt.putDouble("criticalHit", playerState.criticalHit);
            playerDataAsNbt.putDouble("criticalDamage", playerState.criticalDamage);
            playerDataAsNbt.putDouble("speed", playerState.speed);
            playerDataAsNbt.putDouble("endurance", playerState.endurance);
            playerDataAsNbt.putDouble("potential", playerState.potential);
            playerDataAsNbt.putDouble("hit", playerState.hit);
            playerDataAsNbt.putDouble("dodge", playerState.dodge);
            playersNbt.put(String.valueOf(uuid), playerDataAsNbt);
        });
        nbt.put("misty_attribute", playersNbt);
        return nbt;
    }
}
