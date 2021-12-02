package io.github.icrazyblaze.beefyupdate.item;

import com.google.common.primitives.Ints;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

import static io.github.icrazyblaze.beefyupdate.util.EffectInstanceHelper.effect;

public class RedstoneBeefItem extends Item {

    public RedstoneBeefItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack pStack, @Nullable World pLevel, List<ITextComponent> pTooltip, @Nonnull ITooltipFlag pFlag) {
        pTooltip.add(new TranslationTextComponent("item.beefyupdate.redstone_beef.description").withStyle(TextFormatting.DARK_PURPLE));
    }
    
    @Nonnull
    @Override
    public ItemStack finishUsingItem(@Nonnull ItemStack pStack, @Nonnull World pLevel, @Nonnull LivingEntity pEntityLiving) {

        if (pEntityLiving instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) pEntityLiving;

            Collection<EffectInstance> effects = player.getActiveEffects();

            for (int i = 0; i < effects.size(); i++) {
                // Get the current effect instance
                EffectInstance e = (EffectInstance) effects.toArray()[i];

                int newDuration = e.getDuration();
                int maxDuration = 12000;

                // Clamp the duration to a max of 10 minutes
                if (newDuration < maxDuration) {
                    newDuration = Ints.constrainToRange((int) (e.getDuration() * 1.2), 1, maxDuration);
                }

                // Get the same effect but with longer duration
                EffectInstance newEffect = effect(e.getEffect(), newDuration, e.getAmplifier());
                // Remove the old effect and add the new one
                player.removeEffect(e.getEffect());
                player.addEffect(newEffect);

            }
            pLevel.playSound(null, player.blockPosition(), SoundEvents.BREWING_STAND_BREW, SoundCategory.PLAYERS, 1.0F, 1.0F);
            player.getCooldowns().addCooldown(this, 40);
        }
        super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pStack;
    }

}
