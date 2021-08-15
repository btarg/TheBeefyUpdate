package io.github.icrazyblaze.beefyupdate.inventory;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;

public class PortableCraftingMenu extends CraftingMenu {

    public PortableCraftingMenu(int p_39353_, Inventory inventory, ContainerLevelAccess containerLevelAccess) {
        super(p_39353_, inventory, containerLevelAccess);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}