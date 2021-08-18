package io.github.icrazyblaze.beefyupdate.util;

import io.github.icrazyblaze.beefyupdate.Main;
import io.github.icrazyblaze.beefyupdate.entity.BeefGolemEntity;
import io.github.icrazyblaze.beefyupdate.entity.BeefGolemRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ForgeEventSubscribers {

    public static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, Main.MOD_ID);
    public static final RegistryObject<CowLootModifier.Serializer> COW_ANVIL_LOOT_MODIFIER = GLM.register("cow", CowLootModifier.Serializer::new);

    @SubscribeEvent
    public static void registerEntities(EntityAttributeCreationEvent event) {
        event.put(Main.BEEF_GOLEM, BeefGolemEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Main.BEEF_GOLEM, BeefGolemRenderer::new);
    }

}
