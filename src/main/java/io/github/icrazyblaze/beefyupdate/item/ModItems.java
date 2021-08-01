package io.github.icrazyblaze.beefyupdate.item;

import io.github.icrazyblaze.beefyupdate.Main;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.ChorusFruitItem;
import net.minecraft.world.item.EnchantedGoldenAppleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Main.MOD_ID);

    public static final RegistryObject<Item> RAINBOW_BEEF = ITEMS.register("rainbow_beef",
            () -> new EnchantedGoldenAppleItem(new Item.Properties().tab(Main.GROUP).food(ModFoods.RAINBOW_BEEF).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> COAL_BEEF = ITEMS.register("coal_beef",
            () -> new CoalBeefItem(new Item.Properties().tab(Main.GROUP).food(ModFoods.COAL_BEEF)));

    public static final RegistryObject<Item> MYSTERY_BEEF = ITEMS.register("mystery_beef",
            () -> new MysteryBeefItem(new Item.Properties().tab(Main.GROUP).food(ModFoods.ALWAYS_EAT_BEEF).stacksTo(16)));

    public static final RegistryObject<Item> IRON_BEEF = ITEMS.register("iron_beef",
            () -> new Item(new Item.Properties().tab(Main.GROUP).food(ModFoods.IRON_BEEF)));

    public static final RegistryObject<Item> DIAMOND_BEEF = ITEMS.register("diamond_beef",
            () -> new Item(new Item.Properties().tab(Main.GROUP).food(ModFoods.DIAMOND_BEEF)));

    public static final RegistryObject<Item> CHORUS_BEEF = ITEMS.register("chorus_beef",
            () -> new ChorusFruitItem(new Item.Properties().tab(Main.GROUP).food(ModFoods.ALWAYS_EAT_BEEF)));

    public static final RegistryObject<Item> GOLDEN_BEEF = ITEMS.register("golden_beef",
            () -> new Item(new Item.Properties().tab(Main.GROUP).food(ModFoods.GOLDEN_BEEF)));

    public static final RegistryObject<Item> FIERY_BEEF = ITEMS.register("fiery_beef",
            () -> new FieryBeefItem(new Item.Properties().tab(Main.GROUP).food(ModFoods.FIERY_BEEF)));

    public static final RegistryObject<Item> TNT_BEEF = ITEMS.register("tnt_beef",
            () -> new ExplosiveBeefItem(new Item.Properties().tab(Main.GROUP).food(ModFoods.TNT_BEEF)));

    public static final RegistryObject<Item> SPONGE_BEEF = ITEMS.register("sponge_beef",
            () -> new SpongeBeefItem(new Item.Properties().tab(Main.GROUP).food(Foods.APPLE)));

    public static final RegistryObject<Item> CRAFTING_BEEF = ITEMS.register("crafting_beef",
            () -> new CraftingBeefItem(new Item.Properties().tab(Main.GROUP).food(Foods.COOKED_BEEF)));

    public static final RegistryObject<Item> FURNACE_BEEF = ITEMS.register("furnace_beef",
            () -> new FurnaceBeefItem(new Item.Properties().tab(Main.GROUP).food(Foods.COOKED_BEEF)));

    public static final RegistryObject<Item> MISSING_BEEF = ITEMS.register("missing_beef",
            () -> new MissingBeefItem(new Item.Properties().tab(Main.GROUP).food(Foods.COOKED_BEEF)));

    public static final RegistryObject<Item> REDSTONE_BEEF = ITEMS.register("redstone_beef",
            () -> new Item(new Item.Properties().tab(Main.GROUP).food(Foods.COOKED_BEEF)));

    public static final RegistryObject<Item> GLOWSTONE_BEEF = ITEMS.register("glowstone_beef",
            () -> new GlowstoneBeefItem(new Item.Properties().tab(Main.GROUP).food(ModFoods.GLOWSTONE_BEEF)));

    public static final RegistryObject<Item> STEAK_BUCKET = ITEMS.register("steak_bucket",
            () -> new SteakBucketItem(new Item.Properties().tab(Main.GROUP).food(Foods.COOKED_MUTTON).stacksTo(1).durability(1200)));
}
