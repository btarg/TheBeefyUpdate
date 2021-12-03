package io.github.icrazyblaze.beefyupdate.item;

import com.google.common.primitives.Ints;
import io.github.icrazyblaze.beefyupdate.Main;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class FurnaceBeefItem extends Item {

    public FurnaceBeefItem(Properties properties) {
        super(properties);
    }
    
    @Nonnull
    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.STONE_BREAK;
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack pStack, @Nullable World pLevel, List<ITextComponent> pTooltip, @Nonnull ITooltipFlag pFlag) {
        pTooltip.add(new TranslationTextComponent("item.beefyupdate.furnace_beef.description").withStyle(TextFormatting.DARK_PURPLE));
    }
    
    @Nonnull
    @Override
    public ItemStack finishUsingItem(@Nonnull ItemStack pStack, @Nonnull World pLevel, @Nonnull LivingEntity pEntityLiving) {
        if (pEntityLiving instanceof ServerPlayerEntity && !pLevel.isClientSide()) {
            ServerPlayerEntity player = (ServerPlayerEntity) pEntityLiving;

            for (ItemStack fuelStack : player.inventory.items) {
                // If we don't have any fuel then do nothing
                if (ForgeHooks.getBurnTime(fuelStack, null) < 1) {
                    continue;
                }

                // Smelt up to half a stack of items, choosing the amount randomly
                int stackRand = fuelStack.isStackable() ? Main.rand.nextInt(1, fuelStack.getMaxStackSize() / 2) : 1;

                for (ItemStack itemStack : player.inventory.items) {
                    // Get the smelting recipe for the item - if none exists, then we do nothing
                    Optional<FurnaceRecipe> recipe = pLevel.getRecipeManager().getRecipeFor(IRecipeType.SMELTING, new Inventory(itemStack), pLevel);

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
                        player.inventory.add(new ItemStack(recipe.get().getResultItem().getItem(), stackRand));
                        player.giveExperienceLevels((int) recipe.get().getExperience());

                        pLevel.playSound(null, player.blockPosition(), SoundEvents.FURNACE_FIRE_CRACKLE, SoundCategory.PLAYERS, 1.0F, 1.0F);

                        int cooldownTime = Ints.constrainToRange(10 * stackRand, 60, 300);

                        player.getCooldowns().addCooldown(this, cooldownTime);
                        break;

                    }
                }
            }

        }
        super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pStack;
    }


}