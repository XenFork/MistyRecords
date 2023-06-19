package union.xenfork.misty.records;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class MistyRecordsClient implements ClientModInitializer {
    public static final String modid = "misty_records";
    public static final KeyBinding TEST = new KeyBinding("key."+ modid +".test", GLFW.GLFW_KEY_I, "key.categories.misc");

    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(TEST);
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
        });

    }
}
