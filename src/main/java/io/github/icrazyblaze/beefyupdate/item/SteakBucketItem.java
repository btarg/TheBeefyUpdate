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

import java.util.Map;

public class SteakBucketItem extends Item {

    public static final int eatDamage = 400;

    public SteakBucketItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {

        Map<Enchantment, Integer> enchantmentMap = EnchantmentHelper.getEnchantments(book);
        enchantmentMap.keySet().removeIf(entry -> (entry == Enchantments.UNBREAKING || entry == Enchantments.MENDING));

        return enchantmentMap.size() == 0;

    }

    @Override
    public void onUsingTick(ItemStack itemStack, LivingEntity player, int count) {

        int nextDamage = itemStack.getDamageValue() + eatDamage;

        if (nextDamage > itemStack.getMaxDamage()) {
            player.stopUsingItem();
        }

    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {

        if (livingEntity instanceof ServerPlayer player && !level.isClientSide() && !player.isCreative()) {

            player.eat(level, itemStack);
            // Eating reduces the stack so we grow it here
            itemStack.grow(1);

            itemStack.hurtAndBreak(eatDamage, livingEntity, (entity) -> {

                itemStack.shrink(1);
                player.getInventory().add(new ItemStack(Items.BUCKET));

            });

        }
        return itemStack;
    }

}