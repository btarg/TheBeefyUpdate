package io.github.icrazyblaze.beefyupdate.util;

import io.github.icrazyblaze.beefyupdate.Main;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ForgeEventSubscribers {

    public static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, Main.MOD_ID);
    public static final RegistryObject<CowLootModifier.Serializer> COW_ANVIL_LOOT_MODIFIER = GLM.register("cow", CowLootModifier.Serializer::new);

}
