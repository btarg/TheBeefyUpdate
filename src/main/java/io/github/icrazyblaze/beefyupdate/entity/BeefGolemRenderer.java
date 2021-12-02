package io.github.icrazyblaze.beefyupdate.entity;

import io.github.icrazyblaze.beefyupdate.Main;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.IronGolemRenderer;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class BeefGolemRenderer extends IronGolemRenderer {
    private static final ResourceLocation GOLEM_LOCATION = new ResourceLocation(Main.MOD_ID, "textures/entity/beef_golem/beef_golem.png");

    public BeefGolemRenderer(EntityRendererManager rendererManager) {
        super(rendererManager);
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull IronGolemEntity pEntity) {
        return GOLEM_LOCATION;
    }
}
