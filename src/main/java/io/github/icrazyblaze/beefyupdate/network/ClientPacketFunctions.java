package io.github.icrazyblaze.beefyupdate.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.CraftingScreen;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;


/**
 * This class is for functions that only run on the client.
 *
 * @see io.github.icrazyblaze.beefyupdate.network.PacketHandler
 */
public class ClientPacketFunctions {
    /*
        This code is run on the client when the Crafting Screen packet is received.
    */
    public static void showCraftingScreenClient(String title) {

        Player player = Minecraft.getInstance().player;
        CraftingMenu menu = new CraftingMenu(0, player.getInventory(), ContainerLevelAccess.create(player.level, player.blockPosition()));

        Minecraft.getInstance().setScreen(new CraftingScreen(menu, player.getInventory(), new TranslatableComponent(title)));

    }

}
