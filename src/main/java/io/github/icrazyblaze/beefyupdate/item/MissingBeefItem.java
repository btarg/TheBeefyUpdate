package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SDisconnectPacket;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import static io.github.icrazyblaze.beefyupdate.Main.rand;

public class MissingBeefItem extends Item {

    public MissingBeefItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(@Nonnull ItemStack pStack) {
        return true;
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack pStack, @Nullable World pLevel, List<ITextComponent> pTooltip, @Nonnull ITooltipFlag pFlag) {
        pTooltip.add(new TranslationTextComponent("item.beefyupdate.antibeef.description").withStyle(TextFormatting.DARK_PURPLE));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
    
    @Nonnull
    @Override
    public ItemStack finishUsingItem(@Nonnull ItemStack pStack, @Nonnull World pLevel, @Nonnull LivingEntity pEntityLiving) {

        if (pEntityLiving instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) pEntityLiving;
            player.connection.send(new SDisconnectPacket(new TranslationTextComponent("gui.beefyupdate.disconnect" + rand.nextInt(1, 4), player.getDisplayName())));
        }
        super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pStack;
    }
    
    @Nonnull
    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.AMBIENT_CAVE;
    }
}