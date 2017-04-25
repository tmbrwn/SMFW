package oneyre.smfw.proxy;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import oneyre.smfw.rendering.ModelRegistrar;

@SideOnly(Side.CLIENT)
public final class CombinedClientProxy implements IProxy {

	@Override
	public void preInit() {
		ModelRegistrar.registerItemModels();
	}

	@Override
	public void init() {
	}

	@Override
	public void postInit() {
		// TODO Auto-generated method stub

	}

}
