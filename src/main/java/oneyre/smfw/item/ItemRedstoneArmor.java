package oneyre.smfw.item;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import oneyre.smfw.Smfw;
import oneyre.smfw.block.BlockRedstoneActivator;
import oneyre.smfw.init.SmfwBlocks;
import oneyre.smfw.init.SmfwItems;

/**
 * Armor made of redstone which, when worn on the feet, activates redstone
 * devices you walk on.
 * 
 * @author Oneyre
 *
 */
public final class ItemRedstoneArmor extends ItemArmor {

	private static ArmorMaterial redstoneMaterial = EnumHelper.addArmorMaterial("Redstone", Smfw.MODID + ":redstone",
			10, new int[] { 1, 3, 4, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);

	public ItemRedstoneArmor(EntityEquipmentSlot slot) {
		super(redstoneMaterial, -1, slot);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (world.isRemote || !itemStack.getItem().equals(SmfwItems.redstoneArmorFeet))
			return;
		BlockPos feetPos = player.getPosition();
		IBlockState blockInFoot = world.getBlockState(feetPos);
		IBlockState blockInHead = world.getBlockState(feetPos.up());
		if (blockInFoot.getBlock() == Blocks.AIR) {
			world.setBlockState(feetPos, SmfwBlocks.redstoneActivator.getDefaultState());
			world.scheduleUpdate(feetPos, SmfwBlocks.redstoneActivator, BlockRedstoneActivator.TICKS_TO_UPDATE);
		} else if (blockInFoot.getBlock() == SmfwBlocks.redstoneActivator) {
			world.setBlockState(feetPos, blockInFoot.withProperty(BlockRedstoneActivator.IS_PLAYER_IN, true));
		} else if (blockInHead.getBlock() == Blocks.AIR) {
			world.setBlockState(feetPos.up(), SmfwBlocks.redstoneActivator.getDefaultState());
			world.scheduleUpdate(feetPos.up(), SmfwBlocks.redstoneActivator, BlockRedstoneActivator.TICKS_TO_UPDATE);
		} else if (blockInHead.getBlock() == SmfwBlocks.redstoneActivator) {
			world.setBlockState(feetPos.up(), blockInHead.withProperty(BlockRedstoneActivator.IS_PLAYER_IN, true));
		}
	}

}
