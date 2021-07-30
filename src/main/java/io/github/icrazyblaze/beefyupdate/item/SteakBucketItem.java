package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.concurrent.atomic.AtomicBoolean;

public class SteakBucketItem extends Item {

    public SteakBucketItem(Properties properties) {
        super(properties);
    }


    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {

        if (livingEntity instanceof ServerPlayer player) {

            AtomicBoolean destroy = new AtomicBoolean(false);

            player.getItemInHand(player.getUsedItemHand()).hurtAndBreak(1, livingEntity, (entity) -> destroy.set(true));

            player.eat(level, itemStack);

            if (!player.isCreative()) {
                if (!destroy.get()) {
                    itemStack.grow(1);
                } else {
                    itemStack.setDamageValue(itemStack.getMaxDamage());
                    player.getInventory().add(new ItemStack(Items.BUCKET));
                }
            }

        }
        return itemStack;
    }

}