package net.floinker.galaxymc.datagen;

import net.floinker.galaxymc.block.GalaxyMcBlocks;
import net.floinker.galaxymc.item.GalaxyMcItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class GalaxyMcBlockLootTableProvider extends BlockLootSubProvider {
    protected GalaxyMcBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(GalaxyMcBlocks.RAW_TIN_BLOCK.get());
        dropSelf(GalaxyMcBlocks.RAW_TITANIUM_BLOCK.get());
        dropSelf(GalaxyMcBlocks.TIN_BLOCK.get());
        dropSelf(GalaxyMcBlocks.TITANIUM_BLOCK.get());

        add(GalaxyMcBlocks.TIN_ORE.get(),
                block -> createOreDrop(GalaxyMcBlocks.TIN_ORE.get(), GalaxyMcItems.RAW_TIN.get()));
        add(GalaxyMcBlocks.TIN_DEEPSLATE_ORE.get(),
                block -> createOreDrop(GalaxyMcBlocks.TIN_DEEPSLATE_ORE.get(), GalaxyMcItems.RAW_TIN.get()));
        add(GalaxyMcBlocks.TITANIUM_ORE.get(),
                block -> createOreDrop(GalaxyMcBlocks.TITANIUM_ORE.get(), GalaxyMcItems.RAW_TITANIUM.get()));
        add(GalaxyMcBlocks.TITANIUM_DEEPSLATE_ORE.get(),
                block -> createOreDrop(GalaxyMcBlocks.TITANIUM_DEEPSLATE_ORE.get(), GalaxyMcItems.RAW_TITANIUM.get()));
    }

    private LootTable.Builder createMultipleOreDrops(Block pBlock, Item pItem, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock,
                this.applyExplosionDecay(
                        pBlock,
                        LootItem.lootTableItem(pItem)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return GalaxyMcBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
