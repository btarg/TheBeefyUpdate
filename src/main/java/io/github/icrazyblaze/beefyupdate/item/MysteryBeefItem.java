package io.github.icrazyblaze.beefyupdate.item;

import io.github.icrazyblaze.beefyupdate.util.EffectInstanceHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class MysteryBeefItem extends Item {

    public MysteryBeefItem(Properties properties) {
        super(properties);
    }
    
    @Override
    public void appendHoverText(@Nonnull ItemStack pStack, @Nullable World pLevel, List<ITextComponent> pTooltip, @Nonnull ITooltipFlag pFlag) {
        pTooltip.add(new TranslationTextComponent("item.beefyupdate.mystery_beef.description").withStyle(TextFormatting.DARK_PURPLE));
    }
    
    @Nonnull
    @Override
    public ItemStack finishUsingItem(@Nonnull ItemStack pStack, @Nonnull World pLevel, @Nonnull LivingEntity pEntityLiving) {
        if (pEntityLiving instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) pEntityLiving;
            EffectInstance effect = EffectInstanceHelper.getRandomEffect();
            
            player.addEffect(effect);
            player.getCooldowns().addCooldown(this, 40);
        }
        super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pStack;
    }
}
