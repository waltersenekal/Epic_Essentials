package io.github.waltersenekal.epic_essentials;

import io.github.waltersenekal.epic_essentials.block.ModBlocks;
import io.github.waltersenekal.epic_essentials.data.DataGenerators;
import io.github.waltersenekal.epic_essentials.item.ModItems;
import io.github.waltersenekal.epic_essentials.setup.Registration;
import io.github.waltersenekal.epic_essentials.ui.ModTabs;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
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
    public static final Logger LOGGER = LogUtils.getLogger();

    public EpicEssentials(IEventBus eventBus, ModContainer container)
    {
        Registration.init(eventBus);
        //Config.register(container);

        eventBus.addListener(DataGenerators::gatherData);

        eventBus.addListener(FMLClientSetupEvent.class,(fmlClientSetupEvent ->{
            fmlClientSetupEvent.enqueueWork(()->{
                ModList.get().getModContainerById(MODID).ifPresent(modContainer ->{
                    LOGGER.info("Hello from Epic Essentials! using version {}",modContainer.getModInfo().getVersion());
                });
            });
        }));
    }

}
