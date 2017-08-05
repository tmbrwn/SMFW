package oneyre.smfw.rendering;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import oneyre.smfw.Smfw;
import oneyre.smfw.init.SmfwItems;

public class ModelRegistrar {

	public static void registerItemModels() {
		registerModel(SmfwItems.lapisArmorHead, Smfw.MODID + ":lapis_helm");
		registerModel(SmfwItems.lapisArmorChest, Smfw.MODID + ":lapis_chestplate");
		registerModel(SmfwItems.lapisArmorLegs, Smfw.MODID + ":lapis_leggings");
		registerModel(SmfwItems.lapisArmorFeet, Smfw.MODID + ":lapis_boots");
		
		registerModel(SmfwItems.redstoneArmorHead, Smfw.MODID + ":redstone_helm");
		registerModel(SmfwItems.redstoneArmorChest, Smfw.MODID + ":redstone_chestplate");
		registerModel(SmfwItems.redstoneArmorLegs, Smfw.MODID + ":redstone_leggings");
		registerModel(SmfwItems.redstoneArmorFeet, Smfw.MODID + ":redstone_boots");
		
		registerModel(SmfwItems.woodenClub, Smfw.MODID + ":club_wood");
		registerModel(SmfwItems.stoneClub, Smfw.MODID + ":club_stone");
		registerModel(SmfwItems.ironClub, Smfw.MODID + ":club_iron");
		registerModel(SmfwItems.goldClub, Smfw.MODID + ":club_gold");
		registerModel(SmfwItems.diamondClub, Smfw.MODID + ":club_diamond");
		
		registerModel(SmfwItems.woodenShoge, Smfw.MODID + ":shoge_wood");
		registerModel(SmfwItems.stoneShoge, Smfw.MODID + ":shoge_stone");
		registerModel(SmfwItems.ironShoge, Smfw.MODID + ":shoge_iron");
		registerModel(SmfwItems.goldShoge, Smfw.MODID + ":shoge_gold");
		registerModel(SmfwItems.diamondShoge, Smfw.MODID + ":shoge_diamond");
	}

	public static void registerBlockModels() {
	}

	private static void registerModel(Item item, String modelLocation) {
		ModelResourceLocation fullModelLocation = new ModelResourceLocation(modelLocation, "inventory");
		ModelBakery.registerItemVariants(item, fullModelLocation);
		ModelLoader.setCustomMeshDefinition(item, stack -> fullModelLocation);
	}

}
