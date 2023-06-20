package union.xenfork.misty.records;

import net.fabricmc.api.ModInitializer;
import union.xenfork.misty.records.item.ModItems;

public class MistyRecords implements ModInitializer {
    public static final String modid = "misty_records";
//    Identifier capacityStateId = new Identifier(modid, "capacity_state");
    @Override
    public void onInitialize() {
        ModItems.init();
    }
}
