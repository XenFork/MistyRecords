package union.xenfork.misty.records.screen;

import io.wispforest.owo.ui.base.BaseOwoScreen;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.component.LabelComponent;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class QiTrainingTechniqueScreen extends BaseOwoScreen<FlowLayout> {
    private final PlayerEntity player;
    public QiTrainingTechniqueScreen(PlayerEntity player) {
        this.player = player;
    }
    public static final Text hu_ = Text.literal("hu");
    public static final Text xi_ = Text.literal("xi");
    public static final Text d = Text.literal(".");

    public static class Ref {
        public boolean isHu = true;
        public boolean isSleep = false;
        public int time = 0;
        public int ran = 0;
    }

    private final Ref ref = new Ref();
    private LabelComponent test = Components.label(hu_);
    private ButtonComponent hu, xi;

    @Override
    protected @NotNull OwoUIAdapter<FlowLayout> createAdapter() {
        return OwoUIAdapter.create(this, Containers::verticalFlow);
    }

    @Override
    public void tick() {
        super.tick();
        if (hu.getMessage().equals(d)) {
            ref.time++;
            if (ref.time == 0)
                ref.ran = new Random().nextInt(10, 30);
            if (ref.time >= ref.ran) {
                ref.time = 0;
                if (ref.isHu) test.text(hu_);
                else test.text(xi_);

            }
        }
    }

    @Override
    protected void build(FlowLayout rootComponent) {
        rootComponent
                .surface(Surface.VANILLA_TRANSLUCENT)
                .horizontalAlignment(HorizontalAlignment.CENTER)
                .verticalAlignment(VerticalAlignment.CENTER);

        hu = Components.button(hu_, buttonC -> {
            if (test.text().equals(buttonC.getMessage())) {
                player.addAura(new Random().nextDouble(0.0d, 0.33333333d));
                ref.isHu = false;
                ref.isSleep = true;
                ref.time = 0;
                test.text(d);
            }
        });

         xi = Components.button(xi_, buttonC -> {
            if (test.text().equals(buttonC.getMessage())) {
                player.addAura(new Random().nextDouble(0.0d, 0.66666667d));
                ref.isHu = true;
                ref.isSleep = true;
                ref.time = 0;
                test.text(d);
            }
        });

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
