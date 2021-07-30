package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class FurnaceBeefItem extends Item {

    private static final Component CONTAINER_TITLE = new TranslatableComponent("item.beefyupdate.furnace_beef");

    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int p_58431_) {
            return 0;
        }

        @Override
        public void set(int p_39285_, int p_39286_) {

        }

        @Override
        public int getCount() {
            return 0;
        }
    };

    public FurnaceBeefItem(Properties properties) {
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

        if (livingEntity instanceof ServerPlayer player) {
            player.openMenu(this.createMenu(0, player.getInventory()));
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
        super.finishUsingItem(itemStack, level, livingEntity);
        return itemStack;
    }


    private MenuProvider createMenu(int p_59293_, Inventory inventory) {
        return null;
    }


}