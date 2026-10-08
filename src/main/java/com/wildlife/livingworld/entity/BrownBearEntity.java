package com.wildlife.livingworld.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

/** First gameplay prototype; the production version gets its own bear model and taming/owner layer. */
public class BrownBearEntity extends PolarBearEntity {
    private static final String TRUST_KEY = "WildlifeTrust";
    private int trust;

    public BrownBearEntity(EntityType<? extends PolarBearEntity> type, World world) {
        super(type, world);
    }

    public int getTrust() { return trust; }
    public boolean hasWildlifeTrust() { return trust >= 5; }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (stack.isOf(Items.SALMON) || stack.isOf(Items.COD) || stack.isOf(Items.COOKED_SALMON)) {
            if (!player.getAbilities().creativeMode) stack.decrement(1);
            if (!getWorld().isClient && Random.create().nextFloat() < 0.65F) {
                trust = Math.min(5, trust + 1);
                setPersistent();
            }
            return ActionResult.SUCCESS;
        }
        return super.interactMob(player, hand);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt(TRUST_KEY, trust);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        trust = nbt.getInt(TRUST_KEY);
    }
}
