package union.xenfork.misty.records.screen.handle;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;

public class CultivationOfImmortalsScreen extends Screen {
    private final Screen parent;

    protected CultivationOfImmortalsScreen(Screen parent) {
        super(Text.literal("测试"));
        this.parent = parent;
    }

    @Override
    public void close() {
        if (client != null) {
            client.setScreen(parent);
        }
    }
}
