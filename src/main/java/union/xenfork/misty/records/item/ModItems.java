package union.xenfork.misty.records.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.Locale;
import java.util.function.Function;

import static union.xenfork.misty.records.MistyRecords.modid;

public enum ModItems {
    test(settings -> new SkillsBook(settings.maxCount(1)));
    private final Identifier id;
    private final Item item;
    ModItems(Function<Item.Settings, Item> function) {
        id = new Identifier(modid, name().toLowerCase(Locale.ROOT));
        item = function.apply(new Item.Settings());
    }

    public static void init() {
        for (ModItems value : values()) {
            Registry.register(Registries.ITEM, value.id, value.item);
        }
    }
}
