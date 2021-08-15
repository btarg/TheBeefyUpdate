package io.github.icrazyblaze.beefyupdate.item;

import io.github.icrazyblaze.beefyupdate.inventory.PortableCraftingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

public class CraftingBeefItem extends Item {

    private static final Component CONTAINER_TITLE = new TranslatableComponent("container.crafting");

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
        
        if (livingEntity instanceof ServerPlayer player && !level.isClientSide()) {
            NetworkHooks.openGui(player, getMenuProvider(level, player.blockPosition()));
        }
        super.finishUsingItem(itemStack, level, livingEntity);
        return itemStack;
    }

    public MenuProvider getMenuProvider(Level level, BlockPos blockPos) {
        return new SimpleMenuProvider((i, inventory, p_52231_) -> new PortableCraftingMenu(i, inventory, ContainerLevelAccess.create(level, blockPos)), CONTAINER_TITLE);
    }

}
