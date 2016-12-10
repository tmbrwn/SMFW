package oneyre.smfw.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import oneyre.smfw.Smfw;
import oneyre.smfw.block.BlockRedstoneActivator;

public class SmfwBlocks {

	private static final List<Block> blocksToRegister = new ArrayList<>();
	
	public static final BlockRedstoneActivator redstoneActivator = registerLater(setName(new BlockRedstoneActivator(), "redstone_activator"));
	
	public static void registerBlocks() {
		for(Block block : blocksToRegister) {
			GameRegistry.register(block);
		}
	}
	
	public static <T extends Block> T setName(T block, String name) {
		block.setRegistryName(name);
		block.setUnlocalizedName(block.getRegistryName().toString());
		block.setCreativeTab(Smfw.creativeTab);
		return block;
	}
	
	private static <T extends Block> T registerLater(T block) {
		blocksToRegister.add(block);
		return block;
	}

}
