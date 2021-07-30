package io.github.icrazyblaze.beefyupdate.network.packet;

import io.github.icrazyblaze.beefyupdate.network.ClientPacketFunctions;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.function.Supplier;

public class CraftingScreenPacket {

    public String toSend;

    public CraftingScreenPacket(FriendlyByteBuf buf) {
        fromBytes(buf);
    }

    public CraftingScreenPacket(String message) {
        this.toSend = message;
    }

    public void fromBytes(FriendlyByteBuf buf) {
        toSend = buf.readUtf(32767);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {

        String display = this.toSend;
        ctx.get().enqueueWork(() -> ClientPacketFunctions.showCraftingScreenClient(display));

        ctx.get().setPacketHandled(true);

    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUtf(toSend);
    }

}