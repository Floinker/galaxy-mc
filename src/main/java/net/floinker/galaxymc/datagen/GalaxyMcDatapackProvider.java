package net.floinker.galaxymc.datagen;

import net.floinker.galaxymc.GalaxyMcMod;
import net.floinker.galaxymc.worldgen.GalaxyMcBiomeModifiers;
import net.floinker.galaxymc.worldgen.GalaxyMcConfiguredFeatures;
import net.floinker.galaxymc.worldgen.GalaxyMcPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class GalaxyMcDatapackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, GalaxyMcConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, GalaxyMcPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, GalaxyMcBiomeModifiers::bootstrap);

    public GalaxyMcDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(GalaxyMcMod.MOD_ID));
    }
}
