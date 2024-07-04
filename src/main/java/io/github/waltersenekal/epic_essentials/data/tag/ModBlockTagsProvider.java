package io.github.waltersenekal.epic_essentials.data.tag;

import io.github.waltersenekal.epic_essentials.EpicEssentials;
import io.github.waltersenekal.epic_essentials.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, EpicEssentials.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
       tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.BLEEDING_LOG.get())
                .add(ModBlocks.BLEEDING_PLANKS.get())
                .add(ModBlocks.BLEEDING_SLAB.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CHECKERED_TILE.get());
    }
}
