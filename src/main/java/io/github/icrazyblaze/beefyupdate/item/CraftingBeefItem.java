package io.github.icrazyblaze.beefyupdate.item;

import io.github.icrazyblaze.beefyupdate.network.PacketHandler;
import io.github.icrazyblaze.beefyupdate.network.packet.CraftingScreenPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.NetworkDirection;

public class CraftingBeefItem extends Item {

    public CraftingBeefItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
        return 800;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.WOOD_BREAK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {

        // TODO: Make a working Crafting Steak
        if (livingEntity instanceof ServerPlayer player && !level.isClientSide()) {

            PacketHandler.INSTANCE.sendTo(new CraftingScreenPacket("item.beefyupdate.crafting_beef"), player.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
            player.awardStat(Stats.INTERACT_WITH_CRAFTING_TABLE);

        }
        super.finishUsingItem(itemStack, level, livingEntity);
        return itemStack;
    }

}
