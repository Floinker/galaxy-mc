package net.floinker.galaxymc.datagen;

import net.floinker.galaxymc.GalaxyMcMod;
import net.floinker.galaxymc.block.GalaxyMcBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;


public class GalaxyMcBlockStateProvider extends BlockStateProvider {
    public GalaxyMcBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GalaxyMcMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(GalaxyMcBlocks.RAW_TIN_BLOCK);
        blockWithItem(GalaxyMcBlocks.RAW_TITANIUM_BLOCK);
        blockWithItem(GalaxyMcBlocks.TIN_ORE);
        blockWithItem(GalaxyMcBlocks.TIN_DEEPSLATE_ORE);
        blockWithItem(GalaxyMcBlocks.TITANIUM_ORE);
        blockWithItem(GalaxyMcBlocks.TITANIUM_DEEPSLATE_ORE);
        blockWithItem(GalaxyMcBlocks.TIN_BLOCK);
        blockWithItem(GalaxyMcBlocks.TITANIUM_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

//    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
//        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("testmod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
//    }
//
//    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
//        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("testmod:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
//    }
//
//    private void customLamp() {
//        getVariantBuilder(ModBlocks.MAGIC_LAMP.get()).forAllStates(state -> {
//            if (state.getValue(MagicLampBlock.CLICKED)) {
//                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("magic_lamp_on",
//                        ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "block/" + "magic_lamp_on")))};
//            } else {
//                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("magic_lamp_off",
//                        ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "block/" + "magic_lamp_off")))};
//            }
//        });
//        simpleBlockItem(ModBlocks.MAGIC_LAMP.get(), models().cubeAll("magic_lamp_on",
//                ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "block/" + "magic_lamp_on")));
//    }
}
