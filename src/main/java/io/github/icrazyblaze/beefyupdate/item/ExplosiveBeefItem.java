package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ExplosiveBeefItem extends Item {
    public ExplosiveBeefItem(Properties properties) {
        super(properties);
    }
    
    @Nonnull
    @Override
    public ItemStack finishUsingItem(@Nonnull ItemStack pStack, @Nonnull World pLevel, @Nonnull LivingEntity pEntityLiving) {
        if (pEntityLiving instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) pEntityLiving;
            pLevel.explode(null, pEntityLiving.getX(), pEntityLiving.getEyeY(), pEntityLiving.getZ(), 3.0F, Explosion.Mode.BREAK);
            player.getCooldowns().addCooldown(this, 40);
        }
        super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pStack;
    }
    
    @Nonnull
    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.PARROT_IMITATE_CREEPER;
    }
}