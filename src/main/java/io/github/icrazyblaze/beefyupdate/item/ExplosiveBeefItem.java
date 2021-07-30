package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class ExplosiveBeefItem extends Item {

    public ExplosiveBeefItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {

        if (livingEntity instanceof ServerPlayer player) {
            level.explode(null, livingEntity.getX(), livingEntity.getEyeY(), livingEntity.getZ(), 3.0F, Explosion.BlockInteraction.BREAK);
            player.getCooldowns().addCooldown(this, 40);
        }
        super.finishUsingItem(itemStack, level, livingEntity);
        return itemStack;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.PARROT_IMITATE_CREEPER;
    }
}