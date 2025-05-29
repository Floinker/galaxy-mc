package net.floinker.galaxymc.datagen;

import net.floinker.galaxymc.GalaxyMcMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class GalaxyMcItemTagProvider extends ItemTagsProvider {


    public GalaxyMcItemTagProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProviderCompletableFuture, CompletableFuture<TagLookup<Block>> pTagLookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(pPackOutput, pProviderCompletableFuture, pTagLookupCompletableFuture, GalaxyMcMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
//        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
//                .add(Items.COAL)
//                .add(Items.IRON_INGOT);
    }
}
