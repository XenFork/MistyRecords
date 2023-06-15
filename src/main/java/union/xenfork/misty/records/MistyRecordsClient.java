package union.xenfork.misty.records;

import io.wispforest.owo.ui.hud.Hud;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
import union.xenfork.misty.records.screen.handle.CultivationOfImmortalsScreen;

import java.text.MessageFormat;

public class MistyRecordsClient implements ClientModInitializer {
    public static final String modid = "misty_records";
    public static final KeyBinding TEST = new KeyBinding("key."+ modid +".test", GLFW.GLFW_KEY_I, "key.categories.misc");

    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(TEST);
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (TEST.wasPressed()) {
                client.setScreen(new CultivationOfImmortalsScreen());
            }
        });

    }
}
