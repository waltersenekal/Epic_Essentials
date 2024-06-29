package io.github.waltersenekal.epic_essentials.ui;

import io.github.waltersenekal.epic_essentials.block.ModBlocks;
import io.github.waltersenekal.epic_essentials.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static io.github.waltersenekal.epic_essentials.main.EpicEssentials.MODID;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB,MODID);
    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> COOL_STUFF_ITEMS =
    CREATIVE_TABS.register("epicessentialsitems",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.epicessentials"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(()-> ModItems.ORANGE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModItems.ORANGE.get());
                output.accept(ModItems.DRIED_ORANGE.get());
                output.accept(ModItems.TEMPERED_IRON_INGOT.get());
            }).build());
    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> COOL_STUFF_BLOCKS =
    CREATIVE_TABS.register("epicessentialsblocks",()-> CreativeModeTab.builder()
            .title(Component.translatable("blockGroup.epicessentials"))
            .withTabsBefore(COOL_STUFF_ITEMS.getKey())
            .icon(()-> ModItems.CHECKERED_TILE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModBlocks.CHECKERED_TILE.get());
                output.accept(ModBlocks.BLEEDING_LOG.get());
                output.accept(ModBlocks.BLEEDING_PLANKS.get());
                output.accept(ModBlocks.BLEEDING_SLAB.get());
                output.accept(ModBlocks.BIG_MUSHROOM.get());
            }).build());
}
