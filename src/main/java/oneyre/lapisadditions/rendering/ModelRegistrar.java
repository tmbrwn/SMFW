package oneyre.lapisadditions.rendering;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import oneyre.lapisadditions.init.LapisItems;

public class ModelRegistrar {

	public static void registerItemModels() {
		registerModel(LapisItems.lapisArmorHead, "lapisadditions:lapis_helm");
		registerModel(LapisItems.lapisArmorChest, "lapisadditions:lapis_chestplate");
		registerModel(LapisItems.lapisArmorLegs, "lapisadditions:lapis_leggings");
		registerModel(LapisItems.lapisArmorFeet, "lapisadditions:lapis_boots");
	}
;	
	private static void registerModel(Item item, String modelLocation) {
		ModelResourceLocation fullModelLocation = new ModelResourceLocation(modelLocation, "inventory");
		ModelBakery.registerItemVariants(item, fullModelLocation);
		ModelLoader.setCustomMeshDefinition(item, stack -> fullModelLocation);
	}
	
}
