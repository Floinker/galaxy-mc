package net.floinker.galaxymc.datagen;


import net.floinker.galaxymc.GalaxyMcMod;
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
                GalaxyMcItems.RAW_TIN.get()
//                ModBlocks.TIN_ORE.get(),
//                ModBlocks.TIN_DEEPSLATE_ORE.get()
        );
        final List<ItemLike> TITANIUM_SMELTING_INPUTS = List.of(
                GalaxyMcItems.RAW_TITANIUM.get()
//                ModBlocks.TITANIUM_ORE.get(),
//                ModBlocks.TITANIUM_DEEPSLATE_ORE.get()
        );

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_TIN_BLOCK.get())
//                .define('A', ModItems.RAW_TIN.get())
//                .pattern("AAA")
//                .pattern("AAA")
//                .pattern("AAA")
//                .unlockedBy(getHasName(ModItems.RAW_TIN.get()), has(ModItems.RAW_TIN.get()))
//                .save(pRecipeOutput);
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_TITANIUM_BLOCK.get())
//                .define('A', ModItems.RAW_TITANIUM.get())
//                .pattern("AAA")
//                .pattern("AAA")
//                .pattern("AAA")
//                .unlockedBy(getHasName(ModItems.RAW_TITANIUM.get()), has(ModItems.RAW_TITANIUM.get()))
//                .save(pRecipeOutput);
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_TIN.get(), 9)
//                .requires(ModBlocks.RAW_TIN_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.RAW_TIN_BLOCK.get()), has(ModBlocks.RAW_TIN_BLOCK.get()))
//                .save(pRecipeOutput);
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_TITANIUM.get(), 9)
//                .requires(ModBlocks.RAW_TITANIUM_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.RAW_TITANIUM_BLOCK.get()), has(ModBlocks.RAW_TITANIUM_BLOCK.get()))
//                .save(pRecipeOutput);

        oreSmelting(pRecipeOutput, TIN_SMELTING_INPUTS, RecipeCategory.MISC, GalaxyMcItems.TIN_INGOT.get(), 0.25f, 200, "tin_ingot");
        oreSmelting(pRecipeOutput, TITANIUM_SMELTING_INPUTS, RecipeCategory.MISC, GalaxyMcItems.TITANIUM_INGOT.get(), 0.25f, 200, "titanium_ingot");

        oreBlasting(pRecipeOutput, TIN_SMELTING_INPUTS, RecipeCategory.MISC, GalaxyMcItems.TIN_INGOT.get(), 0.25f, 100, "tin_ingot");
        oreBlasting(pRecipeOutput, TITANIUM_SMELTING_INPUTS, RecipeCategory.MISC, GalaxyMcItems.TITANIUM_INGOT.get(), 0.25f, 100, "titanium_ingot");
    }

    protected static void oreSmelting(
            RecipeOutput pRecipeOutput, List<ItemLike> pItemLikes, RecipeCategory pRecipeCategory, ItemLike pItemLike, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pItemLikes, pRecipeCategory, pItemLike, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(
            RecipeOutput pRecipeOutput, List<ItemLike> pItemLikes, RecipeCategory pRecipeCategory, ItemLike pItemLike, float pExperience, int pCookingTime, String pGroup
    ) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pItemLikes, pRecipeCategory, pItemLike, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput pRecipeOutput,
            RecipeSerializer<T> pRecipeSerializer,
            AbstractCookingRecipe.Factory<T> pCookingFactory,
            List<ItemLike> pItemLikes,
            RecipeCategory pRecipeCategory,
            ItemLike pItemLike,
            float pExperience,
            int pCookingTime,
            String pGroup,
            String pRecipeName
    ) {
        for (ItemLike itemlike : pItemLikes) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pRecipeCategory, pItemLike, pExperience, pCookingTime, pRecipeSerializer, pCookingFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, GalaxyMcMod.MOD_ID + ":" + getItemName(pItemLike) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
