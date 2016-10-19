package oneyre.smfw.rendering;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import oneyre.smfw.Smfw;
import oneyre.smfw.init.SmfwBlocks;
import oneyre.smfw.init.SmfwItems;

public class ModelRegistrar {

	public static void registerItemModels() {
		registerModel(SmfwItems.lapisArmorHead, Smfw.MODID + ":lapis_helm");
		registerModel(SmfwItems.lapisArmorChest, Smfw.MODID + ":lapis_chestplate");
		registerModel(SmfwItems.lapisArmorLegs, Smfw.MODID + ":lapis_leggings");
		registerModel(SmfwItems.lapisArmorFeet, Smfw.MODID + ":lapis_boots");
	}
	
	public static void registerBlockModels() {
		registerModel(Item.getItemFromBlock(SmfwBlocks.smfwOakDoor), "minecraft:wooden_door");
	}
;	
	private static void registerModel(Item item, String modelLocation) {
		ModelResourceLocation fullModelLocation = new ModelResourceLocation(modelLocation, "inventory");
		ModelBakery.registerItemVariants(item, fullModelLocation);
		ModelLoader.setCustomMeshDefinition(item, stack -> fullModelLocation);
	}
	
}
