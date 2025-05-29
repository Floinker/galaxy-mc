package net.floinker.galaxymc.datagen;

import net.floinker.galaxymc.GalaxyMcMod;
import net.floinker.galaxymc.block.GalaxyMcBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(GalaxyMcBlocks.RAW_TIN_BLOCK.get())
                .add(GalaxyMcBlocks.RAW_TITANIUM_BLOCK.get())
                .add(GalaxyMcBlocks.TIN_ORE.get())
                .add(GalaxyMcBlocks.TIN_DEEPSLATE_ORE.get())
                .add(GalaxyMcBlocks.TITANIUM_ORE.get())
                .add(GalaxyMcBlocks.TITANIUM_DEEPSLATE_ORE.get())
                .add(GalaxyMcBlocks.TIN_BLOCK.get())
                .add(GalaxyMcBlocks.TITANIUM_BLOCK.get());
//
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(GalaxyMcBlocks.RAW_TIN_BLOCK.get())
                .add(GalaxyMcBlocks.TIN_ORE.get())
                .add(GalaxyMcBlocks.TIN_BLOCK.get());
//
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(GalaxyMcBlocks.RAW_TITANIUM_BLOCK.get())
                .add(GalaxyMcBlocks.TIN_DEEPSLATE_ORE.get())
                .add(GalaxyMcBlocks.TITANIUM_ORE.get())
                .add(GalaxyMcBlocks.TITANIUM_DEEPSLATE_ORE.get())
                .add(GalaxyMcBlocks.TITANIUM_BLOCK.get());
    }
}
