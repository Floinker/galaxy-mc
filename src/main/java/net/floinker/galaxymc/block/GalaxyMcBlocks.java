package net.floinker.galaxymc.block;

import net.floinker.galaxymc.GalaxyMcMod;
import net.floinker.galaxymc.item.GalaxyMcItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class GalaxyMcBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GalaxyMcMod.MOD_ID);

    public static final DeferredBlock<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            () -> new Block(Block.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> RAW_TITANIUM_BLOCK = registerBlock("raw_titanium_block",
            () -> new Block(Block.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(Block.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(Block.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    public static final DeferredBlock<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), Block.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TIN_DEEPSLATE_ORE = registerBlock("tin_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), Block.Properties.of().strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), Block.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> TITANIUM_DEEPSLATE_ORE = registerBlock("titanium_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), Block.Properties.of().strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        GalaxyMcItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
