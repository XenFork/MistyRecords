package union.xenfork.misty.records;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.util.Identifier;
import union.xenfork.misty.records.item.ModItems;

public class MistyRecords implements ModInitializer {
    public static final String modid = "misty_records";
//    Identifier capacityStateId = new Identifier(modid, "capacity_state");
    @Override
    public void onInitialize() {
        ModItems.init();
    }
}
