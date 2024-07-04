package io.github.waltersenekal.epic_essentials.data.lang;

import io.github.waltersenekal.epic_essentials.EpicEssentials;
import io.github.waltersenekal.epic_essentials.block.ModBlocks;
import io.github.waltersenekal.epic_essentials.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnLangProvider extends LanguageProvider {

    public ModEnLangProvider(PackOutput output){
       super(output, EpicEssentials.MODID,"en_us");
    }

    @Override
    protected void addTranslations() {
        addItem(ModItems.ORANGE,"Orange");
        addItem(ModItems.DRIED_ORANGE,"Dried Orange");
        addItem(ModItems.TEMPERED_IRON_INGOT,"Tempered Iron Ingot");
        addBlock(ModBlocks.CHECKERED_TILE,"Checkered Tile");
        addBlock(ModBlocks.BLEEDING_LOG,"Bleeding Log");
        addBlock(ModBlocks.BLEEDING_PLANKS,"Bleeding Planks");
        addBlock(ModBlocks.BLEEDING_SLAB,"Bleeding Slab");
        addBlock(ModBlocks.BIG_MUSHROOM,"Big Mushroom");
        add("creativetab.epicessentials","Epic Essentials");
    }
}
