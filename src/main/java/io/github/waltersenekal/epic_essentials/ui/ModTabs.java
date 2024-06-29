package io.github.waltersenekal.epic_essentials.ui;

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
    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> COOL_STUFF =
    CREATIVE_TABS.register("epicessentials",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.epicessentialsstuff"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(()-> ModItems.ORANGE.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModItems.ORANGE.get());
            }).build());
}
