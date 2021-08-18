package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.game.ClientboundDisconnectPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static io.github.icrazyblaze.beefyupdate.Main.rand;

public class MissingBeefItem extends Item {

    public MissingBeefItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(new TranslatableComponent("item.beefyupdate.antibeef.description").withStyle(ChatFormatting.DARK_PURPLE));
        super.appendHoverText(itemStack, level, components, flag);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {

        if (livingEntity instanceof ServerPlayer player) {
            player.connection.send(new ClientboundDisconnectPacket(new TranslatableComponent("gui.beefyupdate.disconnect" + rand.nextInt(1, 4), player.getDisplayName())));
        }
        super.finishUsingItem(itemStack, level, livingEntity);
        return itemStack;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.AMBIENT_CAVE;
    }
}