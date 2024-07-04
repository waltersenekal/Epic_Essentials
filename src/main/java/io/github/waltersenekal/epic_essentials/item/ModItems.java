package io.github.waltersenekal.epic_essentials.item;

import io.github.waltersenekal.epic_essentials.block.ModBlocks;
import io.github.waltersenekal.epic_essentials.EpicEssentials;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EpicEssentials.MODID);
    public static final DeferredItem<Item> ORANGE = ITEMS.register("orange", ()->
            new Item(new Item.Properties().stacksTo(64).fireResistant().food(ModFoods.ORANGE)));

    public static final DeferredItem<Item> DRIED_ORANGE = ITEMS.register("dried_orange", ()->
            new Item(new Item.Properties().stacksTo(64).fireResistant().food(ModFoods.DRIED_ORANGE)));

    public static final DeferredItem<Item> TEMPERED_IRON_INGOT = ITEMS.register("tempered_iron_ingot", ()->
            new Item(new Item.Properties().stacksTo(64)));

}
