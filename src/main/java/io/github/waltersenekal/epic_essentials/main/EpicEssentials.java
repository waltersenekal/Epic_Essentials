package io.github.waltersenekal.epic_essentials.main;

import io.github.waltersenekal.epic_essentials.block.ModBlocks;
import io.github.waltersenekal.epic_essentials.item.ModItems;
import io.github.waltersenekal.epic_essentials.ui.ModTabs;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(EpicEssentials.MODID)
public class EpicEssentials
{
    public static final String MODID = "epicessentials";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EpicEssentials(IEventBus modEventBus, ModContainer modContainer)
    {
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModTabs.CREATIVE_TABS.register(modEventBus);


    }

}
