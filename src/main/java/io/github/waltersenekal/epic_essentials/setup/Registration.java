package io.github.waltersenekal.epic_essentials.setup;

import io.github.waltersenekal.epic_essentials.block.ModBlocks;
import io.github.waltersenekal.epic_essentials.item.ModItems;
import io.github.waltersenekal.epic_essentials.ui.ModTabs;
import net.neoforged.bus.api.IEventBus;


public class Registration {

    public static void init(IEventBus eventBus){
        ModItems.ITEMS.register(eventBus);
        ModBlocks.BLOCKS.register(eventBus);
        ModTabs.CREATIVE_TAB.register(eventBus);
    }
}
