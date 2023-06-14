package union.xenfork.misty.records.screen.handle;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import static union.xenfork.misty.records.MistyRecords.modid;

public class CultivationOfImmortalsScreenHandle extends ScreenHandler {
    public static final ScreenHandlerType<CultivationOfImmortalsScreenHandle> CULTIVATION_OF_IMMORTALS_SCREEN_HANDLE;

    static {
        CULTIVATION_OF_IMMORTALS_SCREEN_HANDLE = Registry.register(Registries.SCREEN_HANDLER, new Identifier(modid, "cultivation_of_immortals_screen_handle"), new ScreenHandlerType<>(CultivationOfImmortalsScreenHandle::new, FeatureFlags.VANILLA_FEATURES));
    }
    private final Inventory inventory;
    public CultivationOfImmortalsScreenHandle(int syncId, Inventory inventory) {
        super(CULTIVATION_OF_IMMORTALS_SCREEN_HANDLE, syncId);
        this.inventory = inventory;
        checkSize(inventory, inventory.size());
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return null;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return false;
    }
}
