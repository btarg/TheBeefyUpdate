package io.github.icrazyblaze.beefyupdate;

import io.github.icrazyblaze.beefyupdate.init.ModItems;
import io.github.icrazyblaze.beefyupdate.network.PacketHandler;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author RonaRage, AKA Btarg (https://github.com/iCrazyBlaze)
 */
@Mod(Main.MOD_ID)
public class Main {

    public static final String MOD_ID = "beefyupdate";
    public static final Logger logger = LogManager.getLogger(MOD_ID);
    public static final ThreadLocalRandom rand = ThreadLocalRandom.current();
    public static final CreativeModeTab GROUP = new CreativeModeTab(MOD_ID + "_custom_food") {
        @Override
        public ItemStack makeIcon() {
            return ModItems.RAINBOW_BEEF.get().getDefaultInstance();
        }
    };

    public Main() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
        PacketHandler.registerMessages();

    }

}