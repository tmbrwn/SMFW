package oneyre.smfw.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingRecipes {

	public static void registerRecipes() {
		ShapedRecipeBuilder recipeBuilder = new ShapedRecipeBuilder();
		
		// Lapis Armor Items
		ItemStack lapis = new ItemStack(Items.DYE, 1, 4);

		recipeBuilder.clear();
		recipeBuilder.add(lapis, 0, 1, 2, 3, 5);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(new ItemStack(SmfwItems.lapisArmorHead)));

		recipeBuilder.clear();
		recipeBuilder.addAll(lapis).remove(1);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(new ItemStack(SmfwItems.lapisArmorChest)));

		recipeBuilder.clear();
		recipeBuilder.addAll(lapis).remove(4, 7);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(new ItemStack(SmfwItems.lapisArmorLegs)));

		recipeBuilder.clear();
		recipeBuilder.add(lapis, 0, 2, 3, 5);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(new ItemStack(SmfwItems.lapisArmorFeet)));
		
		// Redstone Armor Items
		ItemStack redstone = new ItemStack(Items.REDSTONE, 1, 0);
		
		recipeBuilder.clear();
		recipeBuilder.add(redstone, 0, 1, 2, 3, 5);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(new ItemStack(SmfwItems.redstoneArmorHead)));

		recipeBuilder.clear();
		recipeBuilder.addAll(redstone).remove(1);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(new ItemStack(SmfwItems.redstoneArmorChest)));

		recipeBuilder.clear();
		recipeBuilder.addAll(redstone).remove(4, 7);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(new ItemStack(SmfwItems.redstoneArmorLegs)));

		recipeBuilder.clear();
		recipeBuilder.add(redstone, 0, 2, 3, 5);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(new ItemStack(SmfwItems.redstoneArmorFeet)));
		
		// Clubs
		ItemStack wood = new ItemStack(Blocks.PLANKS, 1, 0);
		ItemStack stone = new ItemStack(Blocks.COBBLESTONE, 1, 0);
		ItemStack iron = new ItemStack(Items.IRON_INGOT, 1, 0);
		ItemStack gold = new ItemStack(Items.GOLD_INGOT, 1, 0);
		ItemStack diamond = new ItemStack(Items.DIAMOND, 1, 0);
		ItemStack stick = new ItemStack(Items.STICK, 1, 0);
		
		recipeBuilder.clear();
		recipeBuilder.add(wood, 1, 2, 3, 4);
		recipeBuilder.add(stick, 6);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(new ItemStack(SmfwItems.woodenClub)));
		
		recipeBuilder.clear();
		recipeBuilder.add(stone, 1, 2, 3, 4);
		recipeBuilder.add(stick, 6);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(new ItemStack(SmfwItems.stoneClub)));
		
		recipeBuilder.clear();
		recipeBuilder.add(iron, 1, 2, 3, 4);
		recipeBuilder.add(stick, 6);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(new ItemStack(SmfwItems.ironClub)));
		
		recipeBuilder.clear();
		recipeBuilder.add(gold, 1, 2, 3, 4);
		recipeBuilder.add(stick, 6);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(new ItemStack(SmfwItems.goldClub)));
		
		recipeBuilder.clear();
		recipeBuilder.add(diamond, 1, 2, 3, 4);
		recipeBuilder.add(stick, 6);
		GameRegistry.addRecipe(recipeBuilder.buildForOutput(new ItemStack(SmfwItems.diamondClub)));
	}

	private static class ShapedRecipeBuilder {

		private ItemStack[] recipe;

		public ShapedRecipeBuilder() {
			recipe = new ItemStack[9];
		}

		public ShapedRecipeBuilder add(ItemStack itemStack, int... positions) {
			for (int pos : positions) {
				recipe[pos] = itemStack;
			}
			return this;
		}

		public ShapedRecipeBuilder addAll(ItemStack itemStack) {
			add(itemStack, 0, 1, 2, 3, 4, 5, 6, 7, 8);
			return this;
		}

		public ShapedRecipeBuilder remove(int... positions) {
			for (int pos : positions) {
				recipe[pos] = null;
			}
			return this;
		}

		public void clear() {
			recipe = new ItemStack[9];
		}

		public IRecipe buildForOutput(ItemStack itemStack) {
			return new ShapedRecipes(recipeWidth(), recipeHeight(), recipe, itemStack);
		}

		private int recipeWidth() {
			if (columnIsNull(0) && columnIsNull(1) && columnIsNull(2))
				return 0;
			else if (columnIsNull(0) || columnIsNull(2)) {
				if (columnIsNull(1))
					return 1;
				else
					return 2;
			} else
				return 3;

		}

		private int recipeHeight() {
			if (rowIsNull(0) && rowIsNull(1) && rowIsNull(2))
				return 0;
			else if (rowIsNull(0) || rowIsNull(2)) {
				if (rowIsNull(1))
					return 1;
				else
					return 2;
			} else
				return 3;
		}

		private boolean columnIsNull(int col) {
			for (int i = 0; i < 3; i++) {
				if (recipe[i * 3] != null)
					return false;
			}
			return true;
		}

		private boolean rowIsNull(int row) {
			for (int i = 0; i < 3; i++) {
				if (recipe[3 * row + i] != null)
					return false;
			}
			return true;
		}

	}

}
