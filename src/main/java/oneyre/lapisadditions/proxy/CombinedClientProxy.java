package oneyre.lapisadditions.proxy;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import oneyre.lapisadditions.rendering.ModelRegistrar;

@SideOnly(Side.CLIENT)
public final class CombinedClientProxy implements IProxy {

	@Override
	public void preInit() {
		ModelRegistrar.registerItemModels();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postInit() {
		// TODO Auto-generated method stub

	}

}
