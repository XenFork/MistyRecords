package union.xenfork.misty.records.screen.handle;

import io.wispforest.owo.ui.base.BaseOwoScreen;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.component.TextAreaComponent;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.*;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CultivationOfImmortalsScreen extends BaseOwoScreen<FlowLayout> {
    @Override
    protected @NotNull OwoUIAdapter<FlowLayout> createAdapter() {
        return OwoUIAdapter.create(this, Containers::verticalFlow);
    }

    @Override
    protected void build(FlowLayout rootComponent) {
        rootComponent
                .surface(Surface.VANILLA_TRANSLUCENT)
                .horizontalAlignment(HorizontalAlignment.CENTER)
                .verticalAlignment(VerticalAlignment.CENTER);
        TextAreaComponent textArea = Components.textArea(Sizing.fixed(50), Sizing.fixed(30), "");
        ButtonComponent button = Components.button(Text.literal("enter"), buttonComponent -> {
            if (textArea.getText().equals("123")) {
                System.out.println("success");
            } else {
                System.out.println("error");
            }
            textArea.setText("");
        });
        rootComponent.child(
                Containers.verticalFlow(Sizing.content(), Sizing.content())
                        .child(textArea)
                        .child(button)
                        .padding(Insets.of(100))
                        .surface(Surface.DARK_PANEL)
                        .verticalAlignment(VerticalAlignment.CENTER)
                        .horizontalAlignment(HorizontalAlignment.CENTER)
        );
    }
}
