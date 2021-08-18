package io.github.icrazyblaze.beefyupdate.entity;

import io.github.icrazyblaze.beefyupdate.Main;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IronGolemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.IronGolem;

public class BeefGolemRenderer extends IronGolemRenderer {
    private static final ResourceLocation GOLEM_LOCATION = new ResourceLocation(Main.MOD_ID, "textures/entity/beef_golem/beef_golem.png");

    public BeefGolemRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(IronGolem p_115012_) {
        return GOLEM_LOCATION;
    }
}
