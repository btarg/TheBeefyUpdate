package io.github.icrazyblaze.beefyupdate.item;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

import static io.github.icrazyblaze.beefyupdate.util.EffectInstanceHelper.effect;

public class ModFoods {

    public static final FoodProperties ALWAYS_EAT_BEEF = new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.8F)
            .meat()
            .alwaysEat().build();

    public static final FoodProperties RAINBOW_BEEF = new FoodProperties.Builder()
            .effect(() -> effect(MobEffects.MOVEMENT_SPEED, 300, 2), 1.0F)
            .effect(() -> effect(MobEffects.REGENERATION, 400, 1), 1.0F)
            .effect(() -> effect(MobEffects.ABSORPTION, 2400, 0), 1.0F)
            .effect(() -> effect(MobEffects.DAMAGE_RESISTANCE, 600, 3), 1.0F)
            .nutrition(8).saturationMod(1.8f)
            .meat().alwaysEat().build();

    public static final FoodProperties COAL_BEEF = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.3F)
            .effect(() -> effect(MobEffects.POISON, 300, 0), 1.0F)
            .effect(() -> effect(MobEffects.HUNGER, 300, 2), 0.3F)
            .meat().build();

    public static final FoodProperties IRON_BEEF = new FoodProperties.Builder()
            .effect(() -> effect(MobEffects.DAMAGE_RESISTANCE, 600, 1), 1.0F)
            .effect(() -> effect(MobEffects.MOVEMENT_SLOWDOWN, 600, 0), 1.0F)
            .nutrition(8).saturationMod(0.8f)
            .meat().build();

    public static final FoodProperties DIAMOND_BEEF = new FoodProperties.Builder()
            .effect(() -> effect(MobEffects.DAMAGE_RESISTANCE, 600, 2), 1.0F)
            .effect(() -> effect(MobEffects.MOVEMENT_SLOWDOWN, 600, 0), 1.0F)
            .nutrition(8).saturationMod(0.8f)
            .meat().build();

    public static final FoodProperties FIERY_BEEF = new FoodProperties.Builder()
            .effect(() -> effect(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F)
            .nutrition(8).saturationMod(0.8f)
            .meat().build();

    public static final FoodProperties TNT_BEEF = new FoodProperties.Builder()
            .effect(() -> effect(MobEffects.DAMAGE_RESISTANCE, 20, 5), 1.0F)
            .nutrition(8).saturationMod(0.8f)
            .meat().build();

    public static final FoodProperties GOLDEN_BEEF = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F)
            .effect(() -> effect(MobEffects.REGENERATION, 100, 1), 1.0F)
            .effect(() -> effect(MobEffects.ABSORPTION, 2400, 0), 1.0F)
            .nutrition(8).saturationMod(1.2f)
            .meat().alwaysEat().build();
}