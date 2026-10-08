package com.wildlife.livingworld.registry;

import com.wildlife.livingworld.WildlifeMod;
import com.wildlife.livingworld.entity.BrownBearEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ModEntities {
    public static final EntityType<BrownBearEntity> BROWN_BEAR = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(WildlifeMod.MOD_ID, "brown_bear"),
            FabricEntityTypeBuilder.createMob(SpawnGroup.CREATURE, BrownBearEntity::new)
                    .dimensions(EntityDimensions.fixed(1.4F, 1.4F))
                    .trackRangeBlocks(12)
                    .trackedUpdateRate(3)
                    .build()
    );

    private ModEntities() {}

    public static void register() {}
}
