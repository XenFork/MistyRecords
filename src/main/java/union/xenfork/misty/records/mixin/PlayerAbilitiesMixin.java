package union.xenfork.misty.records.mixin;

import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import union.xenfork.misty.records.face.GSetPlayerEntity;

@Mixin(PlayerAbilities.class)
public class PlayerAbilitiesMixin implements GSetPlayerEntity {
    public double
            //力量     灵气   防御      血量
            strength = 0, aura = 0, defense= 0, blood= 0,
    //暴击        暴伤             速度     耐力
    criticalHit= 0, criticalDamage= 0, speed= 0, endurance= 0,
    //潜力     命中   闪避
    potential= 0, hit= 0, dodge= 0;
    private final PlayerAbilities abilities = (PlayerAbilities) (Object) this;
    @Inject(method = "readNbt", at = @At("RETURN"))
    private void read(NbtCompound nbt, CallbackInfo ci) {
        strength = nbt.getDouble("strength");
        aura = nbt.getDouble("aura");
        blood = nbt.getDouble("blood");
        defense = nbt.getDouble("defense");
        criticalHit = nbt.getDouble("criticalHit");
        criticalDamage = nbt.getDouble("criticalDamage");
        speed = nbt.getDouble("speed");
        endurance = nbt.getDouble("endurance");
        potential = nbt.getDouble("potential");
        hit = nbt.getDouble("hit");
        dodge = nbt.getDouble("dodge");
    }

    @Inject(method = "writeNbt", at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/NbtCompound;put(Ljava/lang/String;Lnet/minecraft/nbt/NbtElement;)Lnet/minecraft/nbt/NbtElement;"), locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void write(NbtCompound nbt, CallbackInfo ci, NbtCompound nbtCompound) {
        nbt.putDouble("strength", strength);
        nbt.putDouble("aura", aura);
        nbt.putDouble("defense", defense);
        nbt.putDouble("blood", blood);
        nbt.putDouble("criticalHit", criticalHit);
        nbt.putDouble("criticalDamage", criticalDamage);
        nbt.putDouble("speed", speed);
        nbt.putDouble("endurance", endurance);
        nbt.putDouble("potential", potential);
        nbt.putDouble("hit", hit);
        nbt.putDouble("dodge", dodge);
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
        aura+=d;
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
        defense+=d;
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
        blood+=d;
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
        criticalHit+=d;
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
        criticalDamage+=d;
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
        speed+=d;
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
        endurance+=d;
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
        potential+=d;
    }

}
