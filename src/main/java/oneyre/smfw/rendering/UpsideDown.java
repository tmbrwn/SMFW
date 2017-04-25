package oneyre.smfw.rendering;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class UpsideDown {
	
	private Entity entity;
	
	public UpsideDown(Entity entity) {
		this.entity = entity;
	}

	@SubscribeEvent
	public void doPreRender(RenderPlayerEvent.Pre event) {
		GlStateManager.translate(0.0F, event.getEntity().height + 0.1F, 0.0F);
		GlStateManager.rotate(180.0F, 0.0F, 0.0F, 0.0F);
		GlStateManager.rotate(180.0F, 0.0F, 180.0F, 0.0F);
	}
	
	
	@SubscribeEvent
	public void doPostRender(RenderPlayerEvent.Post event) {
		GlStateManager.translate(0.0F, event.getEntity().height + 0.1F, 0.0F);
		GlStateManager.rotate(180.0F, 0.0F, 0.0F, 0.0F);
		GlStateManager.rotate(180.0F, 0.0F, 180.0F, 0.0F);
	}
	

	
}
