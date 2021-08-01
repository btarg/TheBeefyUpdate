package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

import static io.github.icrazyblaze.beefyupdate.util.EffectInstanceHelper.effect;

public class GlowstoneBeefItem extends Item {

    public static final int searchRange = 64;

    public GlowstoneBeefItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {

        if (livingEntity instanceof ServerPlayer player && !level.isClientSide()) {

            List<Entity> entities = level.getEntities(player, player.getBoundingBox().expandTowards(searchRange, searchRange, searchRange));

            for (Entity e : entities) {
                ((LivingEntity) e).addEffect(effect(MobEffects.GLOWING, 200, 0));
            }

            level.playSound(null, player.blockPosition(), SoundEvents.BELL_RESONATE, SoundSource.BLOCKS, 1.0F, 1.0F);
            player.getCooldowns().addCooldown(this, 20);

        }
        super.finishUsingItem(itemStack, level, livingEntity);
        return itemStack;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.AMETHYST_BLOCK_STEP;
    }
}