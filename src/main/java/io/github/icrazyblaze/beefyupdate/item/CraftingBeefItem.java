package io.github.icrazyblaze.beefyupdate.item;

import io.github.icrazyblaze.beefyupdate.inventory.PortableCraftingMenu;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.IContainerProvider;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;

public class CraftingBeefItem extends Item {
    private static final ITextComponent CONTAINER_TITLE = new TranslationTextComponent("item.beefyupdate.crafting_beef");

    public CraftingBeefItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, IRecipeType<?> recipeType) {
        return 800;
    }
    
    @Nonnull
    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.WOOD_BREAK;
    }
    
    @Nonnull
    @Override
    public ItemStack finishUsingItem(@Nonnull ItemStack pStack, @Nonnull World pLevel, @Nonnull LivingEntity pEntityLiving) {
        if (pEntityLiving instanceof ServerPlayerEntity && !pLevel.isClientSide()) {
            ServerPlayerEntity player = (ServerPlayerEntity) pEntityLiving;
            NetworkHooks.openGui(player, getMenuProvider(pLevel, player.blockPosition()));
        }
        super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pStack;
    }

    public INamedContainerProvider getMenuProvider(World world, BlockPos blockPos) {
        return new SimpleNamedContainerProvider((i, inventory, p_52231_) ->  new PortableCraftingMenu(i, inventory, IWorldPosCallable.create(world, blockPos)),CONTAINER_TITLE);
    }
}
