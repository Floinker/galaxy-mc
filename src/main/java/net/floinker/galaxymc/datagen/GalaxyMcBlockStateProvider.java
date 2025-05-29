package net.floinker.galaxymc.datagen;

import net.floinker.galaxymc.GalaxyMcMod;
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
//        blockWithItem(ModBlocks.RAW_TIN_BLOCK);
//        blockWithItem(ModBlocks.RAW_TITANIUM_BLOCK);
//        blockWithItem(ModBlocks.TIN_ORE);
//        blockWithItem(ModBlocks.TIN_DEEPSLATE_ORE);
//        blockWithItem(ModBlocks.TITANIUM_ORE);
//        blockWithItem(ModBlocks.TITANIUM_DEEPSLATE_ORE);
//        blockWithItem(ModBlocks.MAGIC_BLOCK);
//
//        stairsBlock(ModBlocks.RAW_TIN_STAIRS.get(), blockTexture(ModBlocks.RAW_TIN_BLOCK.get()));
//        slabBlock(ModBlocks.RAW_TIN_SLAB.get(), blockTexture(ModBlocks.RAW_TIN_BLOCK.get()), blockTexture(ModBlocks.RAW_TIN_BLOCK.get()));
//
//        buttonBlock(ModBlocks.RAW_TIN_BUTTON.get(), blockTexture(ModBlocks.RAW_TIN_BLOCK.get()));
//        pressurePlateBlock(ModBlocks.RAW_TIN_PRESSURE_PLATE.get(), blockTexture(ModBlocks.RAW_TIN_BLOCK.get()));
//        fenceBlock(ModBlocks.RAW_TIN_FENCE.get(), blockTexture(ModBlocks.RAW_TIN_BLOCK.get()));
//        fenceGateBlock(ModBlocks.RAW_TIN_FENCE_GATE.get(), blockTexture(ModBlocks.RAW_TIN_BLOCK.get()));
//        wallBlock(ModBlocks.RAW_TIN_WALL.get(), blockTexture(ModBlocks.RAW_TIN_BLOCK.get()));
//        doorBlockWithRenderType(ModBlocks.RAW_TIN_DOOR.get(), modLoc("block/raw_tin_door_bottom"), modLoc("block/raw_tin_door_top"), "cutout");
//        trapdoorBlockWithRenderType(ModBlocks.RAW_TIN_TRAPDOOR.get(), modLoc("block/raw_tin_trapdoor"), true, "cutout");
//
//        blockItem(ModBlocks.RAW_TIN_STAIRS);
//        blockItem(ModBlocks.RAW_TIN_SLAB);
//        blockItem(ModBlocks.RAW_TIN_PRESSURE_PLATE);
//        blockItem(ModBlocks.RAW_TIN_FENCE_GATE);
//        blockItem(ModBlocks.RAW_TIN_TRAPDOOR, "_bottom");
//
//        customLamp();
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
