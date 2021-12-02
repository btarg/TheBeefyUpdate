package io.github.icrazyblaze.beefyupdate.item;

import io.github.icrazyblaze.beefyupdate.Main;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FieryBeefItem extends Item {

    public FieryBeefItem(Properties properties) {
        super(properties);
    }
    
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable IRecipeType<?> recipeType) {
        return 1200;
    }
    
    @Override
    public boolean isFireResistant() {
        return true;
    }
    
    @Nonnull
    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_BURN;
    }
    
    @Nonnull
    @Override
    public ItemStack finishUsingItem(@Nonnull ItemStack pStack, @Nonnull World pLevel, @Nonnull LivingEntity pEntityLiving) {
        if (pEntityLiving instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) pEntityLiving;
            BlockPos bpos = pEntityLiving.blockPosition();

            if (pLevel.getBlockState(bpos) == Blocks.AIR.defaultBlockState()) {
                pLevel.setBlock(bpos, Blocks.FIRE.defaultBlockState(), 2);
                pLevel.playSound(null, bpos, SoundEvents.FIRECHARGE_USE, SoundCategory.PLAYERS, 1.0F, 1.0F);
            }

            FireballEntity ent = new FireballEntity(player.level, pEntityLiving, 0D, 0D, 0D);
            ent.explosionPower = Main.rand.nextInt(0, 2);
            ent.shootFromRotation(player, player.xRot, player.yRot, 0.0F, 3.0F, 1.0F);
            ent.moveTo(player.getX(), player.getY(0.5), player.getZ(), 0, 0);

            pLevel.addFreshEntity(ent);
            player.getCooldowns().addCooldown(this, 20);
        }
        super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pStack;
    }
}
