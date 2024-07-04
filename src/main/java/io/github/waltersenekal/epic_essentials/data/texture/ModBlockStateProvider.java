package io.github.waltersenekal.epic_essentials.data.texture;
import io.github.waltersenekal.epic_essentials.EpicEssentials;
import io.github.waltersenekal.epic_essentials.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output,ExistingFileHelper existingFileHelper) {
        super(output, EpicEssentials.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        addNormalBlock(ModBlocks.CHECKERED_TILE.get());
        addNormalBlock(ModBlocks.BLEEDING_PLANKS.get());
        addLogBlock(ModBlocks.BLEEDING_LOG.get());
        addSlabBlock(ModBlocks.BLEEDING_SLAB.get(),ModBlocks.BLEEDING_PLANKS.get());
        //addNormalBlock(ModBlocks.BIG_MUSHROOM.get());
        addFlowerBlock(ModBlocks.BIG_MUSHROOM.get());
    }

    private void addNormalBlock(Block block){
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();
        simpleBlock(block,models().cubeAll(path,modLoc("block/" + path)));
        simpleBlockItem(block,models().getExistingFile(modLoc("block/"+path)));
    }
    private void addFlowerBlock(Block block){
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();
        simpleBlockWithItem(block,models().cross(path,modLoc("block/" + path)).renderType("cutout"));
        simpleBlockItem(block,models().getExistingFile(modLoc("block/"+path)));

    }

    private void addLogBlock(Block block){

        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();
        logBlock((RotatedPillarBlock)block);
        simpleBlockItem(block,models().getExistingFile(modLoc("block/"+path)));
    }

    private void addSlabBlock(Block block,Block parent) {
        ResourceLocation blockKey = BuiltInRegistries.BLOCK.getKey(block);
        String path = blockKey.getPath();
        slabBlock((SlabBlock) block,blockTexture(parent),blockTexture(parent));
        simpleBlockItem(block,models().getExistingFile(modLoc("block/" + path)));
    }



}

