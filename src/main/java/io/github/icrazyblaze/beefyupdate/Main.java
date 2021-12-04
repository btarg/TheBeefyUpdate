package io.github.icrazyblaze.beefyupdate;

import io.github.icrazyblaze.beefyupdate.init.ModItems;
import io.github.icrazyblaze.beefyupdate.util.ForgeEventSubscribers;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author RonaRage, AKA Btarg (https://github.com/iCrazyBlaze)
 */
@Mod(Main.MOD_ID)
public class Main {

    public static final String MOD_ID = "beefyupdate";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final ThreadLocalRandom rand = ThreadLocalRandom.current();
    public static final ItemGroup GROUP_FOOD = new ItemGroup(MOD_ID + ".custom_food") {
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            return ModItems.RAINBOW_BEEF.get().getDefaultInstance();
        }
    };

    public Main() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        
        bus.register(ForgeEventSubscribers.class);
        ModItems.ITEMS.register(bus);

        ENTITIES.register(bus);
        
        MinecraftForge.EVENT_BUS.register(this);
        ForgeEventSubscribers.GLM.register(bus); // Global loot modifiers
    }

}