package union.xenfork.misty.records.components;

import dev.onyxstudios.cca.api.v3.block.BlockComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.block.BlockComponentInitializer;
import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.chunk.ChunkComponentInitializer;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.item.ItemComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.item.ItemComponentInitializer;
import dev.onyxstudios.cca.api.v3.level.LevelComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.level.LevelComponentInitializer;
import dev.onyxstudios.cca.api.v3.scoreboard.ScoreboardComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.scoreboard.ScoreboardComponentInitializer;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import union.xenfork.misty.records.components.aura.ImplComponentImpl;

import static union.xenfork.misty.records.MistyRecords.modid;

public class ComponentsInit implements
        EntityComponentInitializer,
        ChunkComponentInitializer,
        BlockComponentInitializer,
        ItemComponentInitializer,
        LevelComponentInitializer,
        ScoreboardComponentInitializer,
        WorldComponentInitializer {

//    public static final ComponentKey<DoublesComponentImpl> ability = ComponentRegistry.getOrCreate(new Identifier(modid, "ability"), DoublesComponentImpl.class);
    public static final ComponentKey<ImplComponentImpl> aura = ComponentRegistry.getOrCreate(new Identifier(modid, "aura"), ImplComponentImpl.class);
    public static final ComponentKey<ImplComponentImpl> dodge = ComponentRegistry.getOrCreate(new Identifier(modid, "dodge"), ImplComponentImpl.class);
    public static final ComponentKey<ImplComponentImpl> hit = ComponentRegistry.getOrCreate(new Identifier(modid, "hit"), ImplComponentImpl.class);
    public static final ComponentKey<ImplComponentImpl> strength = ComponentRegistry.getOrCreate(new Identifier(modid, "strength"), ImplComponentImpl.class);
    public static final ComponentKey<ImplComponentImpl> defense = ComponentRegistry.getOrCreate(new Identifier(modid, "defense"), ImplComponentImpl.class);
    public static final ComponentKey<ImplComponentImpl> blood = ComponentRegistry.getOrCreate(new Identifier(modid, "blood"), ImplComponentImpl.class);
    public static final ComponentKey<ImplComponentImpl> criticalHit = ComponentRegistry.getOrCreate(new Identifier(modid, "critical_hit"), ImplComponentImpl.class);
    public static final ComponentKey<ImplComponentImpl> criticalDamage = ComponentRegistry.getOrCreate(new Identifier(modid, "critical_damage"), ImplComponentImpl.class);
    public static final ComponentKey<ImplComponentImpl> speed = ComponentRegistry.getOrCreate(new Identifier(modid, "speed"), ImplComponentImpl.class);
    public static final ComponentKey<ImplComponentImpl> endurance = ComponentRegistry.getOrCreate(new Identifier(modid, "endurance"), ImplComponentImpl.class);
    public static final ComponentKey<ImplComponentImpl> potential = ComponentRegistry.getOrCreate(new Identifier(modid, "potential"), ImplComponentImpl.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
//        registry.beginRegistration(PlayerEntity.class, ability).impl(DoublesComponentImpl.class).end(DoublesComponentImpl::new);
        registry.beginRegistration(PlayerEntity.class, aura).impl(ImplComponentImpl.class).end(owner -> new ImplComponentImpl(owner, "aura"));
        registry.beginRegistration(PlayerEntity.class, dodge).impl(ImplComponentImpl.class).end(owner -> new ImplComponentImpl(owner, "dodge"));
        registry.beginRegistration(PlayerEntity.class, hit).impl(ImplComponentImpl.class).end(owner -> new ImplComponentImpl(owner, "hit"));
        registry.beginRegistration(PlayerEntity.class, strength).impl(ImplComponentImpl.class).end(owner -> new ImplComponentImpl(owner, "strength"));
        registry.beginRegistration(PlayerEntity.class, defense).impl(ImplComponentImpl.class).end(owner -> new ImplComponentImpl(owner, "defense"));
        registry.beginRegistration(PlayerEntity.class, blood).impl(ImplComponentImpl.class).end(owner -> new ImplComponentImpl(owner, "blood"));
        registry.beginRegistration(PlayerEntity.class, criticalHit).impl(ImplComponentImpl.class).end(owner -> new ImplComponentImpl(owner, "criticalHit"));
        registry.beginRegistration(PlayerEntity.class, criticalDamage).impl(ImplComponentImpl.class).end(owner -> new ImplComponentImpl(owner, "criticalDamage"));
        registry.beginRegistration(PlayerEntity.class, speed).impl(ImplComponentImpl.class).end(owner -> new ImplComponentImpl(owner, "speed"));
        registry.beginRegistration(PlayerEntity.class, endurance).impl(ImplComponentImpl.class).end(owner -> new ImplComponentImpl(owner, "endurance"));
        registry.beginRegistration(PlayerEntity.class, potential).impl(ImplComponentImpl.class).end(owner -> new ImplComponentImpl(owner, "potential"));
    }

    @Override
    public void registerChunkComponentFactories(ChunkComponentFactoryRegistry registry) {

    }

    @Override
    public void registerBlockComponentFactories(BlockComponentFactoryRegistry registry) {

    }

    @Override
    public void registerItemComponentFactories(ItemComponentFactoryRegistry registry) {

    }

    @Override
    public void registerLevelComponentFactories(LevelComponentFactoryRegistry registry) {

    }

    @Override
    public void registerScoreboardComponentFactories(ScoreboardComponentFactoryRegistry registry) {

    }

    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {

    }
}
