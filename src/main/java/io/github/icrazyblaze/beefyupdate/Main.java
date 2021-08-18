package io.github.icrazyblaze.beefyupdate;

import io.github.icrazyblaze.beefyupdate.entity.BeefGolemEntity;
import io.github.icrazyblaze.beefyupdate.init.ModItems;
import io.github.icrazyblaze.beefyupdate.util.ForgeEventSubscribers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
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
    public static final CreativeModeTab GROUP_FOOD = new CreativeModeTab(MOD_ID + ".custom_food") {
        @Override
        public ItemStack makeIcon() {
            return ModItems.RAINBOW_BEEF.get().getDefaultInstance();
        }
    };

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            Main.MOD_ID);

    public static final EntityType<BeefGolemEntity> BEEF_GOLEM = EntityType.Builder.of(BeefGolemEntity::new, MobCategory.MISC)
            .sized(1.4F, 2.7F).clientTrackingRange(10).build(new ResourceLocation(Main.MOD_ID, "beef_golem").toString());

    public Main() {

        // Forge event bus
        MinecraftForge.EVENT_BUS.register(this);
        // Mod bus
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.register(ForgeEventSubscribers.class);
        ModItems.ITEMS.register(bus);

        // Here we need to register the Golem entity before the Spawn Egg item to prevent bugs
        ENTITIES.register(bus);
        ENTITIES.register("beef_golem", () -> BEEF_GOLEM);

        ModItems.ITEMS.register("beef_golem_spawn_egg", () ->
                new SpawnEggItem(BEEF_GOLEM, 0x5d3829, 0x30180f, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

        // Global loot modifiers
        ForgeEventSubscribers.GLM.register(bus);

    }

}