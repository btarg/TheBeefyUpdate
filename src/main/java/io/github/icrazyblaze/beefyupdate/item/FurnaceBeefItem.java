package io.github.icrazyblaze.beefyupdate.item;

import io.github.icrazyblaze.beefyupdate.Main;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeHooks;

import java.util.Optional;

public class FurnaceBeefItem extends Item {

    public FurnaceBeefItem(Properties properties) {
        super(properties);
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.STONE_BREAK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack thisItemStack, Level level, LivingEntity livingEntity) {

        if (livingEntity instanceof ServerPlayer player && !level.isClientSide()) {

            for (ItemStack fuelStack : player.getInventory().items) {

                // If we don't have any fuel then do nothing
                if (ForgeHooks.getBurnTime(fuelStack, null) < 1) {
                    continue;
                }

                // Smelt up to half a stack of items, choosing the amount randomly
                int stackRand = fuelStack.isStackable() ? Main.rand.nextInt(1, fuelStack.getMaxStackSize() / 2) : 1;

                for (ItemStack itemStack : player.getInventory().items) {

                    // Get the smelting recipe for the item - if none exists, then we do nothing
                    Optional<SmeltingRecipe> recipe = level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(itemStack), level);

                    if (recipe.isPresent()) {

                        // Shrink the stacks if we have the same amount of fuel and items (1:1)
                        // If we don't have enough of either, break the loop and do nothing (just eat the steak)
                        if (itemStack.getCount() >= stackRand) {
                            fuelStack.shrink(stackRand);
                            itemStack.shrink(stackRand);
                        } else {
                            break;
                        }

                        // Add the smelted items and XP
                        player.getInventory().add(new ItemStack(recipe.get().getResultItem().getItem(), stackRand));
                        player.giveExperienceLevels((int) recipe.get().getExperience());

                        break;

                    }
                }
            }

            player.getCooldowns().addCooldown(this, 40);
        }
        super.finishUsingItem(thisItemStack, level, livingEntity);
        return thisItemStack;
    }


}