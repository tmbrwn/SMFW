package oneyre.smfw.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import oneyre.smfw.Smfw;

@SideOnly(Side.SERVER)
public class ServerProxy implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {

	}

	@Override
	public void init(FMLInitializationEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initializeSelf(FMLPreInitializationEvent event) {
    	Smfw.logger.init(event.getModLog());
	}

}
