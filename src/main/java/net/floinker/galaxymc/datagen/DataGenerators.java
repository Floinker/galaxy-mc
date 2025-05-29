package net.floinker.galaxymc.datagen;

import net.floinker.galaxymc.GalaxyMcMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = GalaxyMcMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        dataGenerator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(GalaxyMcBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
        dataGenerator.addProvider(event.includeServer(), new GalaxyMcRecipeProvider(packOutput, lookupProvider));

        BlockTagsProvider blockTagProvider = new GalaxyMcBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        dataGenerator.addProvider(event.includeServer(), blockTagProvider);
        dataGenerator.addProvider(event.includeServer(), new GalaxyMcItemTagProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), existingFileHelper));


        dataGenerator.addProvider(event.includeClient(), new GalaxyMcItemModelProvider(packOutput, existingFileHelper));
        dataGenerator.addProvider(event.includeClient(), new GalaxyMcBlockStateProvider(packOutput, existingFileHelper));

        dataGenerator.addProvider(event.includeServer(), new GalaxyMcDatapackProvider(packOutput, lookupProvider));
    }
}
