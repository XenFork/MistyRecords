package union.xenfork.misty.records.item;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import union.xenfork.misty.records.screen.QiTrainingTechniqueScreen;

public class ExercisesBookItem extends Item {
    public ExercisesBookItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            MinecraftClient instance = MinecraftClient.getInstance();
            instance.setScreen(new QiTrainingTechniqueScreen(instance.player));
        }
        return super.use(world, user, hand);
    }
}
