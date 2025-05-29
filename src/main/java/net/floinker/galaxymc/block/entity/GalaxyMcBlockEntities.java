package net.floinker.galaxymc.block.entity;

import net.floinker.galaxymc.GalaxyMcMod;
import net.floinker.galaxymc.block.GalaxyMcBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class GalaxyMcBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, GalaxyMcMod.MOD_ID);

    public static final Supplier<BlockEntityType<IngotPressBlockEntity>> INGOT_PRESS = BLOCK_ENTITIES.register("ingot_press",
            () -> BlockEntityType.Builder.of(IngotPressBlockEntity::new, GalaxyMcBlocks.INGOT_PRESS.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
