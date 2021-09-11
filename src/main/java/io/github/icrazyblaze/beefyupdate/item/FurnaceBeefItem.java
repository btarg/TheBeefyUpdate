package io.github.icrazyblaze.beefyupdate.item;

import com.google.common.primitives.Ints;
import io.github.icrazyblaze.beefyupdate.Main;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeHooks;

import javax.annotation.Nullable;
import java.util.List;
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
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(new TranslatableComponent("item.beefyupdate.furnace_beef.description").withStyle(ChatFormatting.DARK_PURPLE));
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

                        // Shrink the stacks if we have enough fuel for the items
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

                        level.playSound(null, player.blockPosition(), SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.PLAYERS, 1.0F, 1.0F);

                        int cooldownTime = Ints.constrainToRange(10 * stackRand, 60, 300);

                        player.getCooldowns().addCooldown(this, cooldownTime);
                        break;

                    }
                }
            }

        }
        super.finishUsingItem(thisItemStack, level, livingEntity);
        return thisItemStack;
    }


}