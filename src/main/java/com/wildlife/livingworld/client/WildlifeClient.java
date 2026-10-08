package com.wildlife.livingworld.client;

import com.wildlife.livingworld.registry.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.PolarBearEntityRenderer;

public final class WildlifeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Temporary visual placeholder. Dedicated models/animations come next.
        EntityRendererRegistry.register(ModEntities.BROWN_BEAR, PolarBearEntityRenderer::new);
    }
}
