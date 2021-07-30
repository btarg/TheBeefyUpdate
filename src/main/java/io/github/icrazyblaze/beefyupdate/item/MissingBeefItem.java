package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.game.ClientboundDisconnectPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static io.github.icrazyblaze.beefyupdate.Main.rand;

public class MissingBeefItem extends Item {

    public MissingBeefItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {

        if (livingEntity instanceof ServerPlayer player) {
            player.connection.send(new ClientboundDisconnectPacket(new TranslatableComponent("gui.beefyupdate.disconnect" + rand.nextInt(1, 3))));
        }
        super.finishUsingItem(itemStack, level, livingEntity);
        return itemStack;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.AMBIENT_CAVE;
    }
}