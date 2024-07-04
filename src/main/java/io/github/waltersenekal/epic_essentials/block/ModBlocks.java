package io.github.waltersenekal.epic_essentials.block;

import io.github.waltersenekal.epic_essentials.item.ModItems;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import java.util.function.Supplier;

import static io.github.waltersenekal.epic_essentials.EpicEssentials.MODID;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredBlock<Block> CHECKERED_TILE = registerBlock("checkered_tile", ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

    public static final DeferredBlock<Block> BLEEDING_LOG = registerBlock("bleeding_log", ()-> new BleedingLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)) );

    public static final DeferredBlock<Block> BLEEDING_PLANKS = registerBlock("bleeding_planks", ()-> new BleedingLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) );

    public static final DeferredBlock<Block> BLEEDING_SLAB = registerBlock("bleeding_slab", ()-> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)) );

    public static final DeferredBlock<Block> BIG_MUSHROOM = registerBlock("big_mushroom", ()-> new FlowerBlock( SuspiciousStewEffects.EMPTY, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM) ));

    public static DeferredBlock<Block> registerBlock(String name, Supplier<Block> block){
        DeferredBlock<Block> blockReg = BLOCKS.register(name,block);
        ModItems.ITEMS.register(name,()-> new BlockItem(blockReg.get(),new Item.Properties()));
        return blockReg;
    }
}
