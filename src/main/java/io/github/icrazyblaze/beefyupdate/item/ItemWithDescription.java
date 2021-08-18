package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class ItemWithDescription extends Item {

    private final String description;
    private boolean foil = false;

    public ItemWithDescription(Properties properties, String description, boolean isFoil) {
        super(properties);
        this.description = description;
        this.foil = isFoil;
    }

    public ItemWithDescription(Properties properties, String description) {
        super(properties);
        this.description = description;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return this.foil;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(new TranslatableComponent(description).withStyle(ChatFormatting.DARK_PURPLE));
    }
}
