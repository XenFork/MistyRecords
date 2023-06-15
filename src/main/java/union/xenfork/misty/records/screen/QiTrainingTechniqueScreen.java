package union.xenfork.misty.records.screen;

import io.wispforest.owo.renderdoc.RenderDoc;
import io.wispforest.owo.ui.base.BaseOwoScreen;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.component.LabelComponent;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.*;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import union.xenfork.misty.records.face.GSetPlayerEntity;

import java.util.Random;

public class QiTrainingTechniqueScreen extends BaseOwoScreen<FlowLayout> {
    private final PlayerEntity player;
    public static final Text hu_ = Text.literal("hu");
    public static final Text xi_ = Text.literal("xi");
    public QiTrainingTechniqueScreen(PlayerEntity player) {
        this.player = player;
    }
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
        var ref = new Object() {
            boolean isHu = true;
            boolean isSleep = false;
        };
        LabelComponent test = Components.label(hu_);
        ButtonComponent hu = Components.button(hu_, buttonC -> {
            if (test.text().equals(buttonC.getMessage())) {
                ((GSetPlayerEntity)player).addAura(new Random().nextDouble(0.0d, 0.33333333d));
                ref.isHu = false;
                ref.isSleep = true;
                test.text(Text.literal("."));
            }
        });
        ButtonComponent xi = Components.button(xi_, buttonC -> {
            if (test.text().equals(buttonC.getMessage())) {
                ((GSetPlayerEntity) player).addAura(new Random().nextDouble(0.0d, 0.66666667d));
                ref.isHu = true;
                ref.isSleep = true;
                test.text(Text.literal("."));
            }
        });
        Runnable runnable = () -> {
            while (true) {
                if (ref.isSleep) {
                    int i = new Random().nextInt(1, 20);
                    try {
                        Thread.sleep(i * 1000L);
                    } catch (InterruptedException ignored) {}
                    if (ref.isHu) {
                        test.text(hu_);
                    } else {
                        test.text(xi_);
                    }
                    ref.isSleep = true
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        KeyBinding.onKeyPressed(InputUtil.GLFW_KEY_E);

        rootComponent.child(
                Containers
                        .verticalFlow(Sizing.content(), Sizing.content())
                        .child(test)
                        .child(hu)
                        .child(xi)
                        .padding(Insets.of(100))
                        .surface(Surface.DARK_PANEL)
                        .verticalAlignment(VerticalAlignment.CENTER)
                        .horizontalAlignment(HorizontalAlignment.CENTER)
        );
    }

    public PlayerEntity getPlayer() {
        return player;
    }
}
