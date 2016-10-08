package oneyre.lapisadditions;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import oneyre.lapisadditions.item.LapisItems;

public final class LapisAdditonsCreativeTab extends CreativeTabs {

	public LapisAdditonsCreativeTab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return LapisItems.lapisArmorChest;
	}

}
