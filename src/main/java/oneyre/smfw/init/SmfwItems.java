
package oneyre.smfw.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import oneyre.smfw.Smfw;
import oneyre.smfw.item.ItemLapisArmor;

public final class SmfwItems {

	private static final List<Item> itemsToRegister = new ArrayList<>();
	
	public static final ItemLapisArmor lapisArmorHead = registerLater(setName(new ItemLapisArmor(EntityEquipmentSlot.HEAD), "lapis_helm"));
	public static final ItemLapisArmor lapisArmorChest = registerLater(setName(new ItemLapisArmor(EntityEquipmentSlot.CHEST), "lapis_chestplate"));
	public static final ItemLapisArmor lapisArmorLegs = registerLater(setName(new ItemLapisArmor(EntityEquipmentSlot.LEGS), "lapis_leggings"));
	public static final ItemLapisArmor lapisArmorFeet = registerLater(setName(new ItemLapisArmor(EntityEquipmentSlot.FEET), "lapis_boots"));
	
	public static void registerItems() {
		for(Item item : itemsToRegister) {
			GameRegistry.register(item);
		}
	}
	
	public static <T extends Item> T setName(T item, String name) {
		item.setRegistryName(name);
		item.setUnlocalizedName(item.getRegistryName().toString());
		item.setCreativeTab(Smfw.creativeTab);
		return item;
	}
	
	private static <T extends Item> T registerLater(T item) {
		itemsToRegister.add(item);
		return item;
	}

}
