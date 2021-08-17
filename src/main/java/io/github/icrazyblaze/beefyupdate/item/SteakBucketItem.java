package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

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

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {

        if (livingEntity instanceof ServerPlayer player && !level.isClientSide() && !player.isCreative()) {

            int nextDamage = itemStack.getDamageValue() + eatDamage;

            // Don't allow the player to eat the steak bucket if there's not enough left
            // If there isn't enough durability the player won't gain any nutrition from eating the bucket, but it will still "break"
            if (nextDamage <= itemStack.getMaxDamage()) {

                player.eat(level, itemStack);
                // Eating reduces the stack so we grow it here
                itemStack.grow(1);

            }

            itemStack.hurtAndBreak(eatDamage, livingEntity, (entity) -> {

                itemStack.shrink(1);
                player.getInventory().add(new ItemStack(Items.BUCKET));

            });

        }
        return itemStack;
    }

}