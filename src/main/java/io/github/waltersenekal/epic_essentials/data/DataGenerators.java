package io.github.waltersenekal.epic_essentials.data;

import io.github.waltersenekal.epic_essentials.EpicEssentials;
import io.github.waltersenekal.epic_essentials.data.lang.ModEnLangProvider;
import io.github.waltersenekal.epic_essentials.data.loottable.ModLootTableProvider;
import io.github.waltersenekal.epic_essentials.data.recipe.ModRecipeProvider;
import io.github.waltersenekal.epic_essentials.data.tag.ModBlockTagsProvider;
import io.github.waltersenekal.epic_essentials.data.texture.ModBlockStateProvider;
import io.github.waltersenekal.epic_essentials.data.texture.ModItemStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {
    public static void gatherData(GatherDataEvent event){
        try{
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
            generator.addProvider( true, new ModEnLangProvider(output));
            generator.addProvider( true, new ModItemStateProvider(output,existingFileHelper));
            generator.addProvider( true, new ModBlockStateProvider(output,existingFileHelper));
            generator.addProvider( true, new ModBlockTagsProvider(output,event.getLookupProvider(),existingFileHelper));
            generator.addProvider(true,new ModLootTableProvider(output,event.getLookupProvider()));
            generator.addProvider(true,new ModRecipeProvider(output,event.getLookupProvider()));


        }
        catch (RuntimeException ex){
            EpicEssentials.LOGGER.error("Failed to gather data",ex);
        }
    }
}
