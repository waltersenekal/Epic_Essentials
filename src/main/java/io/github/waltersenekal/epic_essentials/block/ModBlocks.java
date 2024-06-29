package io.github.waltersenekal.epic_essentials.block;

import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static io.github.waltersenekal.epic_essentials.main.EpicEssentials.MODID;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredBlock<Block> CHECKERED_TILE = BLOCKS.register("checkered_tile",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

    public static final DeferredBlock<Block> BLEEDING_LOG = BLOCKS.register("bleeding_log",
            () -> new BleedingLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)) );

    public static final DeferredBlock<Block> BLEEDING_PLANKS = BLOCKS.register("bleeding_planks",
            () -> new BleedingLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) );

    public static final DeferredBlock<Block> BLEEDING_SLAB = BLOCKS.register("bleeding_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)) );

    public static final DeferredBlock<Block> BIG_MUSHROOM = BLOCKS.register("big_mushroom",
            () -> new FlowerBlock( SuspiciousStewEffects.EMPTY, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM) ));

}
