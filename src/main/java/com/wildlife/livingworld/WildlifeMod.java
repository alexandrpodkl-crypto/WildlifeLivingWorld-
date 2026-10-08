package com.wildlife.livingworld;

import com.wildlife.livingworld.registry.ModEntities;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.registry.tag.BiomeTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class WildlifeMod implements ModInitializer {
    public static final String MOD_ID = "wildlife";
    public static final Logger LOGGER = LoggerFactory.getLogger("Wildlife Living World");

    @Override
    public void onInitialize() {
        ModEntities.register();

        FabricDefaultAttributeRegistry.register(
                ModEntities.BROWN_BEAR,
                PolarBearEntity.createPolarBearAttributes()
                        .add(EntityAttributes.GENERIC_MAX_HEALTH, 50.0D)
                        .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 12.0D)
                        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.27D)
                        .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.65D)
                        .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 24.0D)
        );

        BiomeModifications.addSpawn(
                BiomeSelectors.tag(BiomeTags.IS_FOREST),
                SpawnGroup.CREATURE, ModEntities.BROWN_BEAR, 2, 1, 2
        );
        BiomeModifications.addSpawn(
                BiomeSelectors.tag(BiomeTags.IS_TAIGA),
                SpawnGroup.CREATURE, ModEntities.BROWN_BEAR, 4, 1, 2
        );
        BiomeModifications.addSpawn(
                BiomeSelectors.tag(BiomeTags.IS_MOUNTAIN),
                SpawnGroup.CREATURE, ModEntities.BROWN_BEAR, 1, 1, 1
        );

        LOGGER.info("Wildlife Living World initialized for Minecraft 1.21.1");
    }
}
