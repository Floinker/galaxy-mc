package net.floinker.galaxymc.datagen;


import net.floinker.galaxymc.GalaxyMcMod;
import net.floinker.galaxymc.block.GalaxyMcBlocks;
import net.floinker.galaxymc.item.GalaxyMcItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class GalaxyMcRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public GalaxyMcRecipeProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture) {
        super(pPackOutput, providerCompletableFuture);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        final List<ItemLike> TIN_SMELTING_INPUTS = List.of(
                GalaxyMcItems.RAW_TIN,
                GalaxyMcBlocks.TIN_ORE,
                GalaxyMcBlocks.TIN_DEEPSLATE_ORE
        );
        final List<ItemLike> TITANIUM_SMELTING_INPUTS = List.of(
                GalaxyMcItems.RAW_TITANIUM,
                GalaxyMcBlocks.TITANIUM_ORE,
                GalaxyMcBlocks.TITANIUM_DEEPSLATE_ORE
        );

        nineBlockStorageRecipes(pRecipeOutput, RecipeCategory.MISC, GalaxyMcItems.RAW_TIN, RecipeCategory.BUILDING_BLOCKS, GalaxyMcBlocks.RAW_TIN_BLOCK);
        nineBlockStorageRecipes(pRecipeOutput, RecipeCategory.MISC, GalaxyMcItems.RAW_TITANIUM, RecipeCategory.BUILDING_BLOCKS, GalaxyMcBlocks.RAW_TITANIUM_BLOCK);
        nineBlockStorageRecipes(pRecipeOutput, RecipeCategory.MISC, GalaxyMcItems.TIN_INGOT, RecipeCategory.BUILDING_BLOCKS, GalaxyMcBlocks.TIN_BLOCK);
        nineBlockStorageRecipes(pRecipeOutput, RecipeCategory.MISC, GalaxyMcItems.TITANIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, GalaxyMcBlocks.TITANIUM_BLOCK);

        oreSmelting(pRecipeOutput, TIN_SMELTING_INPUTS, RecipeCategory.MISC, GalaxyMcItems.TIN_INGOT.get(), 0.25f, 200, "tin_ingot");
        oreSmelting(pRecipeOutput, TITANIUM_SMELTING_INPUTS, RecipeCategory.MISC, GalaxyMcItems.TITANIUM_INGOT.get(), 0.25f, 200, "titanium_ingot");

        oreBlasting(pRecipeOutput, TIN_SMELTING_INPUTS, RecipeCategory.MISC, GalaxyMcItems.TIN_INGOT.get(), 0.25f, 100, "tin_ingot");
        oreBlasting(pRecipeOutput, TITANIUM_SMELTING_INPUTS, RecipeCategory.MISC, GalaxyMcItems.TITANIUM_INGOT.get(), 0.25f, 100, "titanium_ingot");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, GalaxyMcMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
