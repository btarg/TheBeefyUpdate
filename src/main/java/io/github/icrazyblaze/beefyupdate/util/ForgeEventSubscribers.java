package io.github.icrazyblaze.beefyupdate.util;

import io.github.icrazyblaze.beefyupdate.Main;
import io.github.icrazyblaze.beefyupdate.entity.BeefGolemEntity;
import io.github.icrazyblaze.beefyupdate.entity.BeefGolemRenderer;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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
    public static void registerEntityRenderers(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(Main.BEEF_GOLEM, BeefGolemRenderer::new);
    }

}
