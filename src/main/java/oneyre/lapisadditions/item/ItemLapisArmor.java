package oneyre.lapisadditions.item;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public final class ItemLapisArmor extends ItemArmor {
	
	private static ArmorMaterial lapisMaterial = EnumHelper.addArmorMaterial(
			"Lapis Lazuli",
			"lapisadditions:lapis",
			12,
			new int[]{1,4,5,2},
			20,
			SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
			0.0F
		);
	
	public ItemLapisArmor(EntityEquipmentSlot slot) {
		super(lapisMaterial, -1, slot);
	}

}
