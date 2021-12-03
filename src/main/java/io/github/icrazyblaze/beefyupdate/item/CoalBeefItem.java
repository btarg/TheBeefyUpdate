package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;

public class CoalBeefItem extends Item {

    public CoalBeefItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, IRecipeType<?> recipeType) {
        return 800;
    }
}
