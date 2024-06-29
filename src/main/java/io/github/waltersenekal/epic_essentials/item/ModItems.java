package io.github.waltersenekal.epic_essentials.item;

import io.github.waltersenekal.epic_essentials.main.EpicEssentials;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EpicEssentials.MODID);
    public static final DeferredItem<Item> ORANGE = ITEMS.register("orange", ()->
            new Item(new Item.Properties().stacksTo(16).fireResistant().food(ModFoods.ORANGE)));
}
