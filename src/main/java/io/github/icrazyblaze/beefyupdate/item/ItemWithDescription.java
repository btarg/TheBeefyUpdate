package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
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
    public boolean isFoil(@Nonnull ItemStack pStack) {
        return this.foil;
    }
    
    @Override
    public void appendHoverText(@Nonnull ItemStack pStack, @Nullable World pLevel, List<ITextComponent> pTooltip, @Nonnull ITooltipFlag pFlag) {
        pTooltip.add(new TranslationTextComponent(description).withStyle(TextFormatting.DARK_PURPLE));
    }
}
