package union.xenfork.misty.records.components.aura;

import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class ImplComponentImpl implements ImplComponent, AutoSyncedComponent {
    private double value;
    private final Object owner;

    public Object getOwner() {
        return owner;
    }

    private final String valueName;


    public ImplComponentImpl(Object owner, String valueName) {
        this.owner = owner;
        this.valueName = valueName;
    }

    @Override
    public double get() {
        return value;
    }

    @Override
    public void set(double value) {
        this.value = value;
    }

    @Override
    public void add(double value) {
        this.value+=value;
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        value = tag.getDouble(valueName);
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.putDouble(valueName, value);
    }

    @Override
    public boolean shouldSyncWith(ServerPlayerEntity player) {
        return player == this.owner;
    }

    @Override
    public void writeSyncPacket(PacketByteBuf buf, ServerPlayerEntity recipient) {
        buf.writeDouble(this.value);
    }

    @Override
    public void applySyncPacket(PacketByteBuf buf) {
        this.value = buf.readDouble();
    }
}
