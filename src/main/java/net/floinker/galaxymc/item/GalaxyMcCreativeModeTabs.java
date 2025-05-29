package net.floinker.galaxymc.item;

import net.floinker.galaxymc.GalaxyMcMod;
import net.floinker.galaxymc.block.GalaxyMcBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class GalaxyMcCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> GALAXY_MC_CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GalaxyMcMod.MOD_ID);

    public static final Supplier<CreativeModeTab> GALAXY_MC_ITEMS_TAB = GALAXY_MC_CREATIVE_MODE_TABS.register("galaxy_mc_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> GalaxyMcItems.TIN_INGOT.get().getDefaultInstance())
                    .title(Component.translatable("creativetab.galaxymc.galaxy_mc_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(GalaxyMcItems.RAW_TIN.get());
                        output.accept(GalaxyMcItems.RAW_TITANIUM.get());
                        output.accept(GalaxyMcItems.TIN_INGOT.get());
                        output.accept(GalaxyMcItems.TITANIUM_INGOT.get());
                    })
                    .build()
    );
    public static final Supplier<CreativeModeTab> GALAXY_MC_BLOCKS_TAB = GALAXY_MC_CREATIVE_MODE_TABS.register("galaxy_mc_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(GalaxyMcBlocks.RAW_TIN_BLOCK))
                    .title(Component.translatable("creativetab.galaxymc.galaxy_mc_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(GalaxyMcBlocks.RAW_TIN_BLOCK.get());
                        output.accept(GalaxyMcBlocks.RAW_TITANIUM_BLOCK.get());
                        output.accept(GalaxyMcBlocks.TIN_BLOCK.get());
                        output.accept(GalaxyMcBlocks.TITANIUM_BLOCK.get());
                        output.accept(GalaxyMcBlocks.TIN_ORE.get());
                        output.accept(GalaxyMcBlocks.TIN_DEEPSLATE_ORE.get());
                        output.accept(GalaxyMcBlocks.TITANIUM_ORE.get());
                        output.accept(GalaxyMcBlocks.TITANIUM_DEEPSLATE_ORE.get());
                    })
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(GalaxyMcMod.MOD_ID, "galaxy_mc_items_tab"))
                    .build()
    );


    public static void register(IEventBus eventBus) {
        GALAXY_MC_CREATIVE_MODE_TABS.register(eventBus);
    }
}
