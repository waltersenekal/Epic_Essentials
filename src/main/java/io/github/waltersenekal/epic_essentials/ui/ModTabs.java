package io.github.waltersenekal.epic_essentials.ui;

import io.github.waltersenekal.epic_essentials.block.ModBlocks;
import io.github.waltersenekal.epic_essentials.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashSet;
import java.util.Set;

import static io.github.waltersenekal.epic_essentials.EpicEssentials.MODID;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB,MODID);
    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> EPIC_ESSENTIALS_TAB = CREATIVE_TAB.register("epicessentials",() ->{
        CreativeModeTab.Builder builder= CreativeModeTab.builder();

        builder.displayItems((itemDisplay, output)-> {
            Set<Item> addedItems = new HashSet<>();
            ModItems.ITEMS.getEntries()
                    .stream()
                    .map((item) -> item.get().asItem())
                    .filter(addedItems::add)
                    .forEach(output::accept);
            ModBlocks.BLOCKS.getEntries()
                    .stream()
                    .map((block)->block.get().asItem())
                    .filter(addedItems::add)
                    .forEach(output::accept);
        });
        builder.icon(() -> ModItems.ORANGE.get().getDefaultInstance());
        builder.title(Component.translatable("creativetab.epicessentials"));
        return builder.build();
    });


}
