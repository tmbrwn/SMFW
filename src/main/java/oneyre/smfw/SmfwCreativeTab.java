package oneyre.smfw;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import oneyre.smfw.init.SmfwItems;

public final class SmfwCreativeTab extends CreativeTabs {

	public SmfwCreativeTab(String label) {
		super(label);
		
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(SmfwItems.lapisArmorChest);
	}

}
