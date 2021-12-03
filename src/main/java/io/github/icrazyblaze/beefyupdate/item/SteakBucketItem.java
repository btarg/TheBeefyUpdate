package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class SteakBucketItem extends Item {
    public static final int eatDamage = 400;

    public SteakBucketItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        for (Enchantment e : EnchantmentHelper.getEnchantments(stack).keySet()) {
            if (!e.isCompatibleWith(enchantment)) {
                return false;
            }
        }
        return enchantment == Enchantments.UNBREAKING || enchantment == Enchantments.MENDING;
    }
    
    @Nonnull
    @Override
    public ItemStack finishUsingItem(@Nonnull ItemStack pStack, @Nonnull World pLevel, @Nonnull LivingEntity pEntityLiving) {
        if (pEntityLiving instanceof ServerPlayerEntity && !pLevel.isClientSide()) {
            ServerPlayerEntity player = (ServerPlayerEntity) pEntityLiving;
            if (player.isCreative()) return pStack;
            int nextDamage = pStack.getDamageValue() + eatDamage;

            // Don't allow the player to eat the steak bucket if there's not enough left
            // If there isn't enough durability the player won't gain any nutrition from eating the bucket, but it will still "break"
            if (nextDamage <= pStack.getMaxDamage()) {
                player.eat(pLevel, pStack);
                // Eating reduces the stack so we grow it here
                pStack.grow(1);
            }

            pStack.hurtAndBreak(eatDamage, pEntityLiving, (entity) -> {
                pStack.shrink(1);
                player.inventory.add(new ItemStack(Items.BUCKET));

            });
        }
        return pStack;
    }
}