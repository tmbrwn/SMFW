package oneyre.smfw.proxy;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import oneyre.smfw.entity.EntityFlyingShoge;
import oneyre.smfw.rendering.ModelRegistrar;
import oneyre.smfw.rendering.RenderFlyingShoge;

@SideOnly(Side.CLIENT)
public final class CombinedClientProxy implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		ModelRegistrar.registerItemModels();
		RenderingRegistry.<EntityFlyingShoge>registerEntityRenderingHandler(EntityFlyingShoge.class, RenderFlyingShoge::new);
	}

	@Override
	public void init(FMLInitializationEvent event) {
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initializeSelf(FMLPreInitializationEvent event) {
		// TODO Auto-generated method stub
		
	}

}
