package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import static io.github.icrazyblaze.beefyupdate.util.EffectInstanceHelper.effect;

public class GlowstoneBeefItem extends Item {
    public static final int searchRange = 32;

    public GlowstoneBeefItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack pStack, @Nullable World pLevel, List<ITextComponent> pTooltip, @Nonnull ITooltipFlag pFlag) {
        pTooltip.add(new TranslationTextComponent("item.beefyupdate.glowstone_beef.description").withStyle(TextFormatting.DARK_PURPLE));
    }
    
    @Nonnull
    @Override
    public ItemStack finishUsingItem(@Nonnull ItemStack pStack, @Nonnull World pLevel, @Nonnull LivingEntity pEntityLiving) {
        if (pEntityLiving instanceof ServerPlayerEntity && !pLevel.isClientSide()) {
            ServerPlayerEntity player = (ServerPlayerEntity) pEntityLiving;
            List<Entity> entities = pLevel.getEntities(player, player.getBoundingBox().inflate(searchRange));

            for (Entity e : entities) {
                try {
                    ((LivingEntity) e).addEffect(effect(Effects.GLOWING, 200, 0));
                } catch (Exception ignored) {

                }
            }

            pLevel.playSound(null, player.blockPosition(), SoundEvents.BELL_RESONATE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            player.getCooldowns().addCooldown(this, 40);
        }
        super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pStack;
    }
    
    @Nonnull
    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.NOTE_BLOCK_CHIME;
    }
}