package oneyre.lapisadditions.init;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingRecipes {

	public static void registerRecipes() {
		ItemStack lapis = new ItemStack(Items.DYE, 1, 4);
		
		ShapedRecipeBuilder recipeBuilder = new ShapedRecipeBuilder();
		recipeBuilder.add(lapis, 0, 1, 2, 3, 5);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(LapisItems.lapisArmorHead, 1));
		
		recipeBuilder.clear();
		recipeBuilder.addAll(lapis).remove(1);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(LapisItems.lapisArmorChest, 1));
		
		recipeBuilder.clear();
		recipeBuilder.addAll(lapis).remove(4,7);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(LapisItems.lapisArmorLegs, 1));
		
		recipeBuilder.clear();
		recipeBuilder.add(lapis, 0, 2, 3, 5);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(LapisItems.lapisArmorFeet, 1));
		
	}
	
	private static class ShapedRecipeBuilder {
		
		private ItemStack[] recipe;
		
		public ShapedRecipeBuilder() {
			recipe = new ItemStack[9];
		}
		
		public ShapedRecipeBuilder add(ItemStack itemStack, int... positions) {
			for(int pos : positions) {
				recipe[pos] = itemStack;
			}
			return this;
		}
		
		public ShapedRecipeBuilder addAll(ItemStack itemStack) {
			add(itemStack, 0,1,2,3,4,5,6,7,8,9);
			return this;
		}
		
		public ShapedRecipeBuilder remove(int... positions) {
			for(int pos : positions) {
				recipe[pos] = null;
			}
			return this;
		}
		
		public void clear() {
			recipe = new ItemStack[9];
		}
		
		public IRecipe buildForOutput(Item item, int count) {
			ItemStack output = new ItemStack(item, count);
			//recipes which do not fit in a 2x2 grid are considered 3x3
			int size = fitsIn2x2() ? 2 : 3;
			return new ShapedRecipes(size, size, recipe, output);
		}
		
		private boolean fitsIn2x2() {
			boolean freeColumn = columnIsNull(0) || columnIsNull(2);
			boolean freeRow = rowIsNull(0) || rowIsNull(2);
			return freeColumn && freeRow;
		}
		
		private boolean columnIsNull(int col) {
			for (int i = 0; i < 3; i++) {
				if(recipe[i*3] != null) return false;
			}
			return true;
		}
		private boolean rowIsNull(int row) {
			for (int i = 0; i < 3; i++) {
				if(recipe[3*row + i] != null) return false;
			}
			return true;
		}
		
	}
	
}
