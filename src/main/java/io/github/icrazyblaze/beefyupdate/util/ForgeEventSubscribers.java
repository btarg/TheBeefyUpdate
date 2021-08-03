package io.github.icrazyblaze.beefyupdate.util;

import io.github.icrazyblaze.beefyupdate.Main;
import io.github.icrazyblaze.beefyupdate.entity.BeefGolemEntity;
import net.minecraft.client.renderer.entity.IronGolemRenderer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeEventSubscribers {

    @SubscribeEvent
    public static void registerEntities(EntityAttributeCreationEvent event) {
        event.put(Main.BEEF_GOLEM, BeefGolemEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Main.BEEF_GOLEM, IronGolemRenderer::new);
    }

}
