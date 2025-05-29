package net.floinker.galaxymc.datagen;

import net.floinker.galaxymc.GalaxyMcMod;
import net.floinker.galaxymc.item.GalaxyMcItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class GalaxyMcItemModelProvider extends ItemModelProvider {
    public GalaxyMcItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GalaxyMcMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(GalaxyMcItems.RAW_TIN.get());
        basicItem(GalaxyMcItems.RAW_TITANIUM.get());
        basicItem(GalaxyMcItems.TIN_INGOT.get());
        basicItem(GalaxyMcItems.TITANIUM_INGOT.get());
    }
}
