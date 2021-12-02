package io.github.icrazyblaze.beefyupdate.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.util.IWorldPosCallable;

public class PortableCraftingMenu extends WorkbenchContainer {

    public PortableCraftingMenu(int pContainerId, PlayerInventory pPlayerInventory, IWorldPosCallable pAccess) {
        super(pContainerId, pPlayerInventory, pAccess);
    }

    @Override
    public boolean stillValid(PlayerEntity pPlayer) {
        return true;
    }
}