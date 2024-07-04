package io.github.waltersenekal.epic_essentials.data.recipe;

import io.github.waltersenekal.epic_essentials.EpicEssentials;
import io.github.waltersenekal.epic_essentials.block.ModBlocks;
import io.github.waltersenekal.epic_essentials.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {


    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> p_323846_) {
        super(pOutput, p_323846_);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        addSmeltingRecipe(pRecipeOutput, List.of(Items.IRON_INGOT),ModItems.TEMPERED_IRON_INGOT,0.7f,200);
        addCookingRecipe(pRecipeOutput,ModItems.ORANGE,ModItems.DRIED_ORANGE,0.35f,200);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLEEDING_SLAB,6)
                .define('X', ModBlocks.BLEEDING_PLANKS)
                .pattern("XXX")
                .unlockedBy(getHasName(ModBlocks.BLEEDING_PLANKS.get()),has(ModBlocks.BLEEDING_PLANKS.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.BLEEDING_PLANKS,4)
                .requires(ModBlocks.BLEEDING_LOG)
                .unlockedBy(getHasName(ModBlocks.BLEEDING_LOG.get()),has(ModBlocks.BLEEDING_LOG.get()))
                .save(pRecipeOutput);
    }




    private void addSmeltingRecipe(RecipeOutput pRecipeOutput,List<ItemLike> items_in,ItemLike item_out,float pExperience, int pCookingTime) {
        oreSmelting(pRecipeOutput, items_in,RecipeCategory.MISC,item_out,pExperience,pCookingTime,getItemName(item_out));
        oreBlasting(pRecipeOutput, items_in,RecipeCategory.MISC,item_out,pExperience,pCookingTime/2,getItemName(item_out));

    }
    private void addCookingRecipe(RecipeOutput pRecipeOutput,ItemLike item_in,ItemLike item_out,float pExperience, int pCookingTime){
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(item_in),RecipeCategory.MISC,item_out,pExperience,pCookingTime)
                .unlockedBy(getHasName(item_in), has(item_in))
                .save(pRecipeOutput, EpicEssentials.MODID + ":" + getItemName(item_out) + "_from_smelting");

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(item_in),RecipeCategory.MISC,item_out,pExperience,pCookingTime * 3)
                .unlockedBy(getHasName(item_in), has(item_in))
                .save(pRecipeOutput, EpicEssentials.MODID + ":" + getItemName(item_out) + "_from_campfire_cooking");

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(item_in),RecipeCategory.MISC,item_out,pExperience,pCookingTime/2)
                .unlockedBy(getHasName(item_in), has(item_in))
                .save(pRecipeOutput, EpicEssentials.MODID + ":" + getItemName(item_out) + "_from_smoker");
    }



    protected static void oreSmelting(
            @NotNull RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup
    ) {
        oreCooking(
                pRecipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTime,
                pGroup,
                "_from_smelting"
        );
    }

    protected static void oreBlasting(
            @NotNull RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience, int pCookingTime, @NotNull String pGroup
    ) {
        oreCooking(
                pRecipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTime,
                pGroup,
                "_from_blasting"
        );
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(
            @NotNull RecipeOutput pRecipeOutput,
            RecipeSerializer<T> pSerializer,
            AbstractCookingRecipe.@NotNull Factory<T> pRecipeFactory,
            List<ItemLike> pIngredients,
            @NotNull RecipeCategory pCategory,
            @NotNull ItemLike pResult,
            float pExperience,
            int pCookingTime,
            @NotNull String pGroup,
            String pSuffix
    ) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, EpicEssentials.MODID + ":" + getItemName(pResult) + pSuffix );
        }
    }
}
