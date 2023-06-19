package union.xenfork.misty.records;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.PersistentStateManager;
import union.xenfork.misty.records.item.ModItems;
import union.xenfork.misty.records.states.CapacityState;
import union.xenfork.misty.records.states.PlayerState;

public class MistyRecords implements ModInitializer {
    public static final String modid = "misty_records";
    Identifier capacityStateId = new Identifier(modid, "capacity_state");
    @Override
    public void onInitialize() {
        ModItems.init();
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            PersistentStateManager persistentStateManager = server.getOverworld().getPersistentStateManager();
            CapacityState capacityState = persistentStateManager.getOrCreate(
                    CapacityState::create,
                    CapacityState::new,
                    modid + "_states"
            );
            PlayerState playerState = CapacityState.getPlayerState(handler.player);
            PacketByteBuf data = PacketByteBufs.create();
            data.writeDouble(playerState.strength);
            data.writeDouble(playerState.aura);
            data.writeDouble(playerState.defense);
            data.writeDouble(playerState.blood);
            data.writeDouble(playerState.criticalHit);
            data.writeDouble(playerState.criticalDamage);
            data.writeDouble(playerState.speed);
            data.writeDouble(playerState.endurance);
            data.writeDouble(playerState.potential);
            data.writeDouble(playerState.hit);
            data.writeDouble(playerState.dodge);
        });
    }
}
