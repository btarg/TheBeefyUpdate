package io.github.icrazyblaze.beefyupdate.util;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.registries.ForgeRegistries;

import static io.github.icrazyblaze.beefyupdate.Main.rand;

public class EffectInstanceHelper {

    public static MobEffectInstance getRandomEffect() {

        int length = ForgeRegistries.POTIONS.getKeys().toArray().length;
        int r = rand.nextInt(length);

        MobEffect effect = MobEffect.byId(r);

        if (effect != null) {
            return new MobEffectInstance(effect, rand.nextInt(100, 600), rand.nextInt(1, 5));
        }
        return new MobEffectInstance(MobEffects.REGENERATION, 100, 0);

    }

    public static MobEffectInstance effect(MobEffect type, int duration, int amplifier) {
        return new MobEffectInstance(type, duration, amplifier);
    }
}
