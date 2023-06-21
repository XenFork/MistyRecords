package union.xenfork.misty.records.components;

import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class DoublesComponentImpl implements
        DoublesComponent,
        AutoSyncedComponent {
    private double
            aura = 0,
            dodge = 0,
            hit = 0,
            strength = 0,
            defense = 0,
            blood = 0,
            criticalHit = 0,
            criticalDamage = 0,
            speed = 0,
            endurance = 0,
            potential = 0;

    private PlayerEntity owner;

    public DoublesComponentImpl(PlayerEntity owner) {
        this.owner = owner;
    }

    @Override
    public double getBlood() {
        return blood;
    }

    @Override
    public boolean shouldSyncWith(ServerPlayerEntity player) {
        return player == this.owner;
    }

    @Override
    public void writeSyncPacket(PacketByteBuf buf, ServerPlayerEntity recipient) {
        AutoSyncedComponent.super.writeSyncPacket(buf, recipient);
    }

    @Override
    public void applySyncPacket(PacketByteBuf buf) {
        AutoSyncedComponent.super.applySyncPacket(buf);
    }

    @Override
    public void setBlood(double blood) {
        this.blood = blood;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        aura = tag.getDouble("aura");
        dodge = tag.getDouble("dodge");
        hit = tag.getDouble("hit");
        strength = tag.getDouble("strength");
        defense = tag.getDouble("defense");
        blood = tag.getDouble("blood");
        criticalHit = tag.getDouble("criticalHit");
        criticalDamage = tag.getDouble("criticalDamage");
        speed = tag.getDouble("speed");
        endurance = tag.getDouble("endurance");
        potential = tag.getDouble("potential");
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putDouble("aura", aura);
        tag.putDouble("dodge", dodge);
        tag.putDouble("hit", hit);
        tag.putDouble("strength", strength);
        tag.putDouble("defense", defense);
        tag.putDouble("blood", blood);
        tag.putDouble("criticalHit", criticalHit);
        tag.putDouble("criticalDamage", criticalDamage);
        tag.putDouble("speed", speed);
        tag.putDouble("endurance", endurance);
        tag.putDouble("potential", potential);
    }

    @Override
    public double getDodge() {
       return dodge;
    }

    @Override
    public void setDodge(double dodge) {
        this.dodge = dodge;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public void addDodge(double d) {
        dodge+=d;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public double getHit() {
        return hit;
    }

    @Override
    public void setHit(double hit) {
        this.hit = hit;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public void addHit(double d) {
        hit+=d;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public double getStrength() {
        return strength;
    }

    @Override
    public void setStrength(double strength) {
        this.strength = strength;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public void addStrength(double d) {
        strength+=d;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public double getAura() {
        return aura;
    }

    @Override
    public void setAura(double aura) {
        this.aura = aura;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public void addAura(double d) {
        aura+=d;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public double getDefense() {
        return defense;
    }

    @Override
    public void setDefense(double defense) {
        this.defense = defense;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public void addDefense(double d) {
        defense+=d;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public void addBlood(double d) {
        blood+=d;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public double getCriticalHit() {
        return criticalHit;
    }

    @Override
    public void setCriticalHit(double criticalHit) {
        this.criticalHit = criticalHit;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public void addCriticalHit(double d) {
        criticalHit+=d;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public double getCriticalDamage() {
        return criticalDamage;
    }

    @Override
    public void setCriticalDamage(double criticalDamage) {
        this.criticalDamage = criticalDamage;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public void addCriticalDamage(double d) {
        criticalDamage+=d;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public void addSpeed(double d) {
        speed+=d;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public double getEndurance() {
        return endurance;
    }

    @Override
    public void setEndurance(double endurance) {
        this.endurance = endurance;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public void addEndurance(double d) {
        endurance+=d;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public double getPotential() {
        return potential;
    }

    @Override
    public void setPotential(double potential) {
        this.potential = potential;
        ComponentsInit.ability.sync(this);
    }

    @Override
    public void addPotential(double d) {
        potential+=d;
        ComponentsInit.ability.sync(this);
    }
}
