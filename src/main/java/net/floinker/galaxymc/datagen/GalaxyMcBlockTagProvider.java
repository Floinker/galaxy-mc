package net.floinker.galaxymc.datagen;

import net.floinker.galaxymc.GalaxyMcMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class GalaxyMcBlockTagProvider extends BlockTagsProvider {
    public GalaxyMcBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GalaxyMcMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
//        tag(BlockTags.MINEABLE_WITH_PICKAXE)
//                .add(ModBlocks.RAW_TIN_BLOCK.get())
//                .add(ModBlocks.RAW_TITANIUM_BLOCK.get())
//                .add(ModBlocks.TIN_ORE.get())
//                .add(ModBlocks.TIN_DEEPSLATE_ORE.get())
//                .add(ModBlocks.TITANIUM_ORE.get())
//                .add(ModBlocks.TITANIUM_DEEPSLATE_ORE.get())
//                .add(ModBlocks.MAGIC_BLOCK.get());
//
//        tag(BlockTags.NEEDS_STONE_TOOL)
//                .add(ModBlocks.RAW_TIN_BLOCK.get())
//                .add(ModBlocks.TIN_ORE.get());
//
//        tag(BlockTags.NEEDS_IRON_TOOL)
//                .add(ModBlocks.RAW_TITANIUM_BLOCK.get())
//                .add(ModBlocks.TIN_DEEPSLATE_ORE.get())
//                .add(ModBlocks.TITANIUM_ORE.get())
//                .add(ModBlocks.TITANIUM_DEEPSLATE_ORE.get())
//                .add(ModBlocks.MAGIC_BLOCK.get());
    }
}
