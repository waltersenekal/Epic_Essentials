package io.github.waltersenekal.epic_essentials.data.loottable;

import io.github.waltersenekal.epic_essentials.EpicEssentials;
import io.github.waltersenekal.epic_essentials.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables( HolderLookup.Provider p_344943_) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), p_344943_);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.CHECKERED_TILE.get());
        dropSelf(ModBlocks.BLEEDING_LOG.get());
        dropSelf(ModBlocks.BLEEDING_PLANKS.get());
        dropSelf(ModBlocks.BIG_MUSHROOM.get());
        add(ModBlocks.BLEEDING_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BLEEDING_SLAB.get()));

    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter(key->key.getNamespace().equals(EpicEssentials.MODID))
                        .isPresent())
                .collect(Collectors.toSet());
    }
}
