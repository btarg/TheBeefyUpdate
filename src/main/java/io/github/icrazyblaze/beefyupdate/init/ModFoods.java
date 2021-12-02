package io.github.icrazyblaze.beefyupdate.init;

import net.minecraft.item.Food;
import net.minecraft.potion.Effects;

import static io.github.icrazyblaze.beefyupdate.util.EffectInstanceHelper.effect;

public class ModFoods {

    public static final Food ALWAYS_EAT_BEEF = new Food.Builder()
            .nutrition(8).saturationMod(0.8F)
            .meat().alwaysEat().build();

    public static final Food RAINBOW_BEEF = new Food.Builder()
            .effect(() -> effect(Effects.MOVEMENT_SPEED, 300, 2), 1.0F)
            .effect(() -> effect(Effects.REGENERATION, 400, 1), 1.0F)
            .effect(() -> effect(Effects.ABSORPTION, 2400, 0), 1.0F)
            .effect(() -> effect(Effects.DAMAGE_RESISTANCE, 600, 3), 1.0F)
            .nutrition(8).saturationMod(1.8f)
            .meat().alwaysEat().build();

    public static final Food COAL_BEEF = new Food.Builder()
            .nutrition(6).saturationMod(0.3F)
            .meat().build();

    public static final Food IRON_BEEF = new Food.Builder()
            .effect(() -> effect(Effects.DAMAGE_RESISTANCE, 600, 1), 1.0F)
            .effect(() -> effect(Effects.MOVEMENT_SLOWDOWN, 600, 0), 1.0F)
            .nutrition(8).saturationMod(0.8f)
            .meat().alwaysEat().build();

    public static final Food DIAMOND_BEEF = new Food.Builder()
            .effect(() -> effect(Effects.DAMAGE_RESISTANCE, 600, 2), 1.0F)
            .effect(() -> effect(Effects.MOVEMENT_SLOWDOWN, 600, 0), 1.0F)
            .nutrition(8).saturationMod(0.8f)
            .meat().alwaysEat().build();

    public static final Food FIERY_BEEF = new Food.Builder()
            .effect(() -> effect(Effects.FIRE_RESISTANCE, 1200, 0), 1.0F)
            .nutrition(8).saturationMod(0.8f)
            .meat().alwaysEat().build();

    public static final Food TNT_BEEF = new Food.Builder()
            .effect(() -> effect(Effects.DAMAGE_RESISTANCE, 20, 5), 1.0F)
            .nutrition(8).saturationMod(0.8f)
            .meat().alwaysEat().build();

    public static final Food GOLDEN_BEEF = new Food.Builder()
            .effect(() -> effect(Effects.REGENERATION, 100, 1), 1.0F)
            .effect(() -> effect(Effects.ABSORPTION, 2400, 0), 1.0F)
            .nutrition(8).saturationMod(1.2f)
            .meat().alwaysEat().build();

    public static final Food GLOWSTONE_BEEF = new Food.Builder()
            .effect(() -> effect(Effects.NIGHT_VISION, 900, 0), 1.0F)
            .effect(() -> effect(Effects.GLOWING, 200, 0), 1.0F)
            .nutrition(6).saturationMod(0.8f)
            .meat().alwaysEat().build();
}