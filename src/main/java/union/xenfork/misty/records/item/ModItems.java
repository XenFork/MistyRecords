package union.xenfork.misty.records.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static union.xenfork.misty.records.MistyRecords.modid;

public class ModItems {

    public static final Item test = new ExercisesBookItem(new Item.Settings());
    public static void init() {
        Registry.register(Registries.ITEM, new Identifier(modid, "test"), test);
    }
}
