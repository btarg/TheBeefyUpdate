package io.github.icrazyblaze.beefyupdate.item;

import io.github.icrazyblaze.beefyupdate.util.EffectInstanceHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class MysteryBeefItem extends Item {

    public MysteryBeefItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(new TranslatableComponent("item.beefyupdate.mystery_beef.description"));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {

        if (livingEntity instanceof ServerPlayer player) {

            MobEffectInstance effect = EffectInstanceHelper.getRandomEffect();

            player.addEffect(effect);
            player.getCooldowns().addCooldown(this, 40);

        }
        super.finishUsingItem(itemStack, level, livingEntity);
        return itemStack;
    }

}
