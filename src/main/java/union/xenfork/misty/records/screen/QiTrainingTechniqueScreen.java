package union.xenfork.misty.records.screen;

import io.wispforest.owo.ui.base.BaseOwoScreen;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.component.LabelComponent;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.*;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import union.xenfork.misty.records.components.ComponentsInit;

import java.util.Random;

import static union.xenfork.misty.records.components.ComponentsInit.ability;

public class QiTrainingTechniqueScreen extends BaseOwoScreen<FlowLayout> {
    private final ClientPlayerEntity player;
    public QiTrainingTechniqueScreen(ClientPlayerEntity player) {
        this.player = player;

    }
    public static final Text hu_ = Text.literal("hu");
    public static final Text xi_ = Text.literal("xi");
    public static final Text d = Text.literal(".");



    private final LabelComponent test = Components.label(hu_);
    private int time = 0;
    private int ran;
    boolean isHu;
    private ButtonComponent hu, xi;

    @Override
    protected @NotNull OwoUIAdapter<FlowLayout> createAdapter() {
        return OwoUIAdapter.create(this, Containers::verticalFlow);
    }

    @Override
    public void tick() {
        super.tick();
        System.out.println(hu.getX());
        System.out.println(xi.getX());
        if (test.text().equals(d)) {
            time++;
            if (time >= ran) {
                time = 0;
                if (isHu) {
                    test.text(hu_);
                } else {
                    test.text(xi_);
                }
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
                isHu = false;
                time = 0;
                ran = new Random().nextInt(10, 100);
                System.out.println(player.getComponent(ability).getAura());
//                System.out.println(player.getAbilities().getAura());
                test.text(d);
            }
        });

        xi = Components.button(xi_, buttonC -> {
            if (test.text().equals(buttonC.getMessage())) {
                isHu = true;
                time = 0;
                ran = new Random().nextInt(10, 100);
                player.getComponent(ability).addAura(new Random().nextDouble(0.0d, 1.0001d));
//                player.getAbilities().addAura(new Random().nextDouble(0.0d, 1.0001d));
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
}
