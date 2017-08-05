package oneyre.smfw.ability;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import oneyre.smfw.rendering.UpsideDown;

public class PutDownPig {
	
	private UpsideDown upsideDown;
	
	public PutDownPig(UpsideDown upsideDown) {
		this.upsideDown = upsideDown;
	}

	@SubscribeEvent
	public void putDownPig(RightClickBlock event) {
//		MinecraftForge.EVENT_BUS.unregister(upsideDown);
		MinecraftForge.EVENT_BUS.unregister(this);
//		if(!event.getWorld().isRemote)
		event.getEntity().removePassengers();
	}
}
