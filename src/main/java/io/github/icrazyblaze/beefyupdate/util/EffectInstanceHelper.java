package io.github.icrazyblaze.beefyupdate.util;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.registries.ForgeRegistries;

import static io.github.icrazyblaze.beefyupdate.Main.rand;

public class EffectInstanceHelper {

    public static EffectInstance getRandomEffect() {

        int length = ForgeRegistries.POTIONS.getKeys().toArray().length;
        int r = rand.nextInt(length);

        Effect effect = Effect.byId(r);

        if (effect != null) {
            return new EffectInstance(effect, rand.nextInt(100, 600), rand.nextInt(1, 5));
        }
        return new EffectInstance(Effects.REGENERATION, 100, 0);
    }

    public static EffectInstance effect(Effect type, int duration, int amplifier) {
        return new EffectInstance(type, duration, amplifier);
    }
}
