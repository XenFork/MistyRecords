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
    private double strength, aura;
    @Inject(method = "readCustomDataFromNbt", at = @At("RETURN"))
    private void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        strength = (nbt.contains("strength")) ? nbt.getDouble("strength") : 0.0d;
        aura = nbt.contains("aura") ? nbt.getDouble("aura") : 0.0d;
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("RETURN"))
    private void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        nbt.putDouble("strength", strength);
        nbt.putDouble("aura", aura);
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
}
