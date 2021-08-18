package io.github.icrazyblaze.beefyupdate.item;

import io.github.icrazyblaze.beefyupdate.Main;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class FieryBeefItem extends Item {

    public FieryBeefItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
        return 1200;
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_BURN;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {

        if (livingEntity instanceof ServerPlayer player) {

            BlockPos bpos = livingEntity.blockPosition();

            if (level.getBlockState(bpos) == Blocks.AIR.defaultBlockState()) {
                level.setBlock(bpos, Blocks.FIRE.defaultBlockState(), 2);
                level.playSound(null, bpos, SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
            }

            LargeFireball ent = new LargeFireball(player.level, player, 0D, 0D, 0D, Main.rand.nextInt(0, 2));
            ent.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
            ent.moveTo(player.getX(), player.getY(0.5), player.getZ(), 0, 0);

            level.addFreshEntity(ent);
            player.getCooldowns().addCooldown(this, 40);

        }

        super.finishUsingItem(itemStack, level, livingEntity);
        return itemStack;
    }

}
