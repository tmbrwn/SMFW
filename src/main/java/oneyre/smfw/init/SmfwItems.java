package oneyre.smfw.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import oneyre.smfw.Smfw;
import oneyre.smfw.item.ItemClub;
import oneyre.smfw.item.ItemLapisArmor;
import oneyre.smfw.item.ItemRedstoneArmor;

public final class SmfwItems {

	private static final List<Item> itemsToRegister = new ArrayList<>();
	
	public static final ItemLapisArmor lapisArmorHead = registerLater(setName(new ItemLapisArmor(EntityEquipmentSlot.HEAD), "lapis_helm"));
	public static final ItemLapisArmor lapisArmorChest = registerLater(setName(new ItemLapisArmor(EntityEquipmentSlot.CHEST), "lapis_chestplate"));
	public static final ItemLapisArmor lapisArmorLegs = registerLater(setName(new ItemLapisArmor(EntityEquipmentSlot.LEGS), "lapis_leggings"));
	public static final ItemLapisArmor lapisArmorFeet = registerLater(setName(new ItemLapisArmor(EntityEquipmentSlot.FEET), "lapis_boots"));
	
	public static final ItemRedstoneArmor redstoneArmorHead = registerLater(setName(new ItemRedstoneArmor(EntityEquipmentSlot.HEAD), "redstone_helm"));
	public static final ItemRedstoneArmor redstoneArmorChest = registerLater(setName(new ItemRedstoneArmor(EntityEquipmentSlot.CHEST), "redstone_chestplate"));
	public static final ItemRedstoneArmor redstoneArmorLegs = registerLater(setName(new ItemRedstoneArmor(EntityEquipmentSlot.LEGS), "redstone_leggings"));
	public static final ItemRedstoneArmor redstoneArmorFeet = registerLater(setName(new ItemRedstoneArmor(EntityEquipmentSlot.FEET), "redstone_boots"));
	
	public static final ItemClub woodenClub = registerLater(setName(new ItemClub(Item.ToolMaterial.WOOD), "club_wood"));
	public static final ItemClub stoneClub = registerLater(setName(new ItemClub(Item.ToolMaterial.STONE), "club_stone"));
	public static final ItemClub ironClub = registerLater(setName(new ItemClub(Item.ToolMaterial.IRON), "club_iron"));
	public static final ItemClub goldClub = registerLater(setName(new ItemClub(Item.ToolMaterial.GOLD), "club_gold"));
	public static final ItemClub diamondClub = registerLater(setName(new ItemClub(Item.ToolMaterial.DIAMOND), "club_diamond"));
	
	public static void registerItems() {
		for(Item item : itemsToRegister) {
			GameRegistry.register(item);
		}
	}
	
	private static <T extends Item> T setName(T item, String name) {
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
