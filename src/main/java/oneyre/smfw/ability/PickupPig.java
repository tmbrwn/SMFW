package oneyre.smfw.ability;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import oneyre.smfw.rendering.UpsideDown;

public class PickupPig {

	@SubscribeEvent
	public void pickUpPig(EntityInteract event) {
		//Make sure you can't do this multiple times
		UpsideDown upsideDownHandler = new UpsideDown(event.getTarget());
//		MinecraftForge.EVENT_BUS.register(upsideDownHandler);
		MinecraftForge.EVENT_BUS.register(new PutDownPig(upsideDownHandler));
		
		
		/*if(!event.getWorld().isRemote) {
			EntityPlayerMP player = null;
			if(event.getEntity() instanceof EntityPlayerMP)
				player = (EntityPlayerMP) event.getEntity();
			else
				return;
			if(event.getTarget().startRiding(event.getEntity(), true));
				if(player.connection != null) {
					player.connection.sendPacket(new SPacketSetPassengers(event.getTarget()));
			    }
		}*/
	}
	
}
