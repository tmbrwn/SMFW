
package oneyre.lapisadditions;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class LapisItems {

	private static final List<Item> itemsToRegister = new ArrayList<>();
	
	public static final ItemLapisArmor lapisArmorHead = registerLater(setName(new ItemLapisArmor(EntityEquipmentSlot.HEAD), "Lapis Helm"));
	public static final ItemLapisArmor lapisArmorChest = registerLater(setName(new ItemLapisArmor(EntityEquipmentSlot.CHEST), "Lapis Chestplate"));
	public static final ItemLapisArmor lapisArmorLegs = registerLater(setName(new ItemLapisArmor(EntityEquipmentSlot.LEGS), "Lapis Leggings"));
	public static final ItemLapisArmor lapisArmorFeet = registerLater(setName(new ItemLapisArmor(EntityEquipmentSlot.FEET), "Lapis Boots"));
	
	public static void registerItems() {
		for(Item item : itemsToRegister) {
			GameRegistry.register(item);
		}
	}
	
	public static <T extends Item> T setName(T item, String name) {
		item.setRegistryName(name);
		item.setUnlocalizedName(item.getRegistryName().toString());
		item.setCreativeTab(LapisAdditions.creativeTab);
		return item;
	}
	
	private static <T extends Item> T registerLater(T item) {
		itemsToRegister.add(item);
		return item;
	}

}
