package io.github.icrazyblaze.beefyupdate.network;

import io.github.icrazyblaze.beefyupdate.Main;
import io.github.icrazyblaze.beefyupdate.network.packet.CraftingScreenPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fmllegacy.network.NetworkRegistry;
import net.minecraftforge.fmllegacy.network.simple.SimpleChannel;

public class PacketHandler {

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(Main.MOD_ID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );
    private static int ID = 0;

    public static void registerMessages() {

        INSTANCE.registerMessage(nextID(),
                CraftingScreenPacket.class,
                CraftingScreenPacket::toBytes,
                CraftingScreenPacket::new,
                CraftingScreenPacket::handle);

    }

    public static int nextID() {
        return ID++;
    }

}