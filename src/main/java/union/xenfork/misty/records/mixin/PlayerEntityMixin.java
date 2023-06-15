package union.xenfork.misty.records.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import union.xenfork.misty.records.face.GSetPlayerEntity;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin implements GSetPlayerEntity {

    private double
            //力量     灵气   防御      血量
            strength, aura, defense, blood,
            //暴击        暴伤             速度     耐力
            criticalHit, criticalDamage, speed, endurance,
            //潜力     命中   闪避
            potential, hit, dodge;
    @Inject(method = "readCustomDataFromNbt", at = @At("RETURN"))
    private void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        setStrength((nbt.contains("strength")) ? nbt.getDouble("strength") : 0.0d);
        setAura(nbt.contains("aura") ? nbt.getDouble("aura") : 0.0d);
        setDefense(nbt.contains("defense") ? nbt.getDouble("defense") : 0.0d);
        setBlood(nbt.contains("blood") ? nbt.getDouble("blood") : 0.0d);
        setCriticalHit(nbt.contains("criticalHit") ? nbt.getDouble("criticalHit") : 0.0d);
        setCriticalDamage(nbt.contains("criticalDamage") ? nbt.getDouble("criticalDamage") : 0.0d);
        setSpeed(nbt.contains("speed") ? nbt.getDouble("speed") : 0.0d);
        setEndurance(nbt.contains("endurance") ? nbt.getDouble("endurance") : 0.0d);
        setPotential(nbt.contains("potential") ? nbt.getDouble("potential") : 0.0d);
        setHit(nbt.contains("hit") ? nbt.getDouble("hit") : 0.0d);
        setDodge(nbt.contains("dodge") ? nbt.getDouble("dodge") : 0.0d);
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("RETURN"))
    private void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putDouble("strength", getStrength());
        nbt.putDouble("aura", getAura());
        nbt.putDouble("defense", getDefense());
        nbt.putDouble("blood", getBlood());
        nbt.putDouble("criticalHit", getCriticalHit());
        nbt.putDouble("criticalDamage", getCriticalDamage());
        nbt.putDouble("speed", getSpeed());
        nbt.putDouble("endurance", getEndurance());
        nbt.putDouble("potential", getPotential());
        nbt.putDouble("hit", getHit());
        nbt.putDouble("dodge", getDodge());
    }
    @Override
    public double getDodge() {
        return dodge;
    }
    @Override
    public void setDodge(double dodge) {
        this.dodge = dodge;
    }
    @Override
    public void addDodge(double d) {
        this.dodge+=d;
    }

    @Override
    public double getHit() {
        return hit;
    }
    @Override
    public void setHit(double hit) {
        this.hit = hit;
    }
    @Override
    public void addHit(double d) {
        this.hit+=d;
    }

    @Override
    public double getStrength() {
        return strength;
    }

    @Override
    public void setStrength(double strength) {
        this.strength = strength;
    }

    @Override
    public void addStrength(double d) {
        this.strength+=d;
    }

    @Override
    public double getAura() {
        return aura;
    }

    @Override
    public void setAura(double aura) {
        this.aura = aura;
    }

    @Override
    public void addAura(double d) {
        this.aura+=d;
    }

    @Override
    public double getDefense() {
        return defense;
    }

    @Override
    public void setDefense(double defense) {
        this.defense = defense;
    }

    @Override
    public void addDefense(double d) {
        this.defense+=d;
    }

    @Override
    public double getBlood() {
        return blood;
    }

    @Override
    public void setBlood(double blood) {
        this.blood = blood;
    }

    @Override
    public void addBlood(double d) {
        this.blood+=d;
    }

    @Override
    public double getCriticalHit() {
        return criticalHit;
    }

    @Override
    public void setCriticalHit(double criticalHit) {
        this.criticalHit = criticalHit;
    }

    @Override
    public void addCriticalHit(double d) {
        this.criticalHit+=d;
    }

    @Override
    public double getCriticalDamage() {
        return criticalDamage;
    }

    @Override
    public void setCriticalDamage(double criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    @Override
    public void addCriticalDamage(double d) {
        this.criticalDamage+=d;
    }
    @Override
    public double getSpeed() {
        return speed;
    }
    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void addSpeed(double d) {
        this.speed+=d;
    }

    @Override
    public double getEndurance() {
        return endurance;
    }

    @Override
    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }

    @Override
    public void addEndurance(double d) {
        this.endurance+=d;
    }
    @Override
    public double getPotential() {
        return potential;
    }
    @Override
    public void setPotential(double potential) {
        this.potential = potential;
    }
    @Override
    public void addPotential(double d) {
        this.potential+=d;
    }
}
