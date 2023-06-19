package union.xenfork.misty.records.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import union.xenfork.misty.records.face.GSetPlayerEntity;
import union.xenfork.misty.records.states.CapacityState;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin implements GSetPlayerEntity {
    private final ServerPlayerEntity player = (ServerPlayerEntity) (Object) this;
    @Override
    public double getDodge() {
        return CapacityState.getPlayerState(player).dodge;
    }
    @Override
    public void setDodge(double dodge) {
        CapacityState.getPlayerState(player).dodge = dodge;
    }
    @Override
    public void addDodge(double d) {
        CapacityState.getPlayerState(player).dodge+=d;
    }

    @Override
    public double getHit() {
        return CapacityState.getPlayerState(player).hit;
    }
    @Override
    public void setHit(double hit) {
        CapacityState.getPlayerState(player).hit = hit;
    }
    @Override
    public void addHit(double d) {
        CapacityState.getPlayerState(player).hit+=d;
    }

    @Override
    public double getStrength() {
        return CapacityState.getPlayerState(player).strength;
    }

    @Override
    public void setStrength(double strength) {
        CapacityState.getPlayerState(player).strength = strength;
    }

    @Override
    public void addStrength(double d) {
        CapacityState.getPlayerState(player).strength+=d;
    }

    @Override
    public double getAura() {
        return CapacityState.getPlayerState(player).aura;
    }

    @Override
    public void setAura(double aura) {
        CapacityState.getPlayerState(player).aura = aura;
    }

    @Override
    public void addAura(double d) {
        CapacityState.getPlayerState(player).aura+=d;
    }

    @Override
    public double getDefense() {
        return CapacityState.getPlayerState(player).defense;
    }

    @Override
    public void setDefense(double defense) {
        CapacityState.getPlayerState(player).defense = defense;
    }

    @Override
    public void addDefense(double d) {
        CapacityState.getPlayerState(player).defense+=d;
    }

    @Override
    public double getBlood() {
        return CapacityState.getPlayerState(player).blood;
    }

    @Override
    public void setBlood(double blood) {
        CapacityState.getPlayerState(player).blood = blood;
    }

    @Override
    public void addBlood(double d) {
        CapacityState.getPlayerState(player).blood+=d;
    }

    @Override
    public double getCriticalHit() {
        return CapacityState.getPlayerState(player).criticalHit;
    }

    @Override
    public void setCriticalHit(double criticalHit) {
        CapacityState.getPlayerState(player).criticalHit = criticalHit;
    }

    @Override
    public void addCriticalHit(double d) {
        CapacityState.getPlayerState(player).criticalHit+=d;
    }

    @Override
    public double getCriticalDamage() {
        return CapacityState.getPlayerState(player).criticalDamage;
    }

    @Override
    public void setCriticalDamage(double criticalDamage) {
        CapacityState.getPlayerState(player).criticalDamage = criticalDamage;
    }

    @Override
    public void addCriticalDamage(double d) {
        CapacityState.getPlayerState(player).criticalDamage+=d;
    }
    @Override
    public double getSpeed() {
        return CapacityState.getPlayerState(player).speed;
    }
    @Override
    public void setSpeed(double speed) {
        CapacityState.getPlayerState(player).speed = speed;
    }

    @Override
    public void addSpeed(double d) {
        CapacityState.getPlayerState(player).speed+=d;
    }

    @Override
    public double getEndurance() {
        return CapacityState.getPlayerState(player).endurance;
    }

    @Override
    public void setEndurance(double endurance) {
        CapacityState.getPlayerState(player).endurance = endurance;
    }

    @Override
    public void addEndurance(double d) {
        CapacityState.getPlayerState(player).endurance+=d;
    }
    @Override
    public double getPotential() {
        return CapacityState.getPlayerState(player).potential;
    }
    @Override
    public void setPotential(double potential) {
        CapacityState.getPlayerState(player).potential = potential;
    }
    @Override
    public void addPotential(double d) {
        CapacityState.getPlayerState(player).potential+=d;
    }
}
