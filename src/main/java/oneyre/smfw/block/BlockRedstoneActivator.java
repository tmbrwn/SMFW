package oneyre.smfw.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialTransparent;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * An invisible block which provides power to blocks below it. Takes 20 ticks to
 * decay if the IS_PLAYER_IN property is not set externally.
 * 
 * @author Oneyre
 *
 */
public class BlockRedstoneActivator extends Block {

	public static final IProperty<Boolean> IS_PLAYER_IN = PropertyBool.create("is_player_in");
	public static final int TICKS_TO_UPDATE = 5;
	public static final int POWER_LEVEL = 4;

	public BlockRedstoneActivator() {
		super(new MaterialTransparent(MapColor.AIR));
		IBlockState defaultBlockState = this.blockState.getBaseState().withProperty(IS_PLAYER_IN, true);
		setDefaultState(defaultBlockState);
	}

	/**
	 * Reminder: Instantiates IBlockState objects for all combinations of values for
	 * associated IProperties. Must override this to use IProperties
	 */
	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, IS_PLAYER_IN);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(IS_PLAYER_IN) ? 1 : 0;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		if (meta == 0)
			return this.getDefaultState().withProperty(IS_PLAYER_IN, false);
		else
			return this.getDefaultState();
	}

	@Override
	public boolean canProvidePower(IBlockState state) {
		return true;
	}

	@Override
	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		if (side == EnumFacing.UP)
			return POWER_LEVEL;
		return 0;
	}

	/*
	 * @Override public int getStrongPower(IBlockState blockState, IBlockAccess
	 * blockAccess, BlockPos pos, EnumFacing side) { return 15; }
	 */

	@Override
	public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
		return EnumBlockRenderType.INVISIBLE;
	}

	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid) {
		return false;
	}

	@Override
	public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (worldIn.isRemote)
			return;
		if (state.getValue(IS_PLAYER_IN)) {
			worldIn.setBlockState(pos, state.withProperty(IS_PLAYER_IN, false));
			worldIn.scheduleUpdate(pos, state.getBlock(), TICKS_TO_UPDATE);
		} else
			worldIn.setBlockToAir(pos);

	}

	@Override
	public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		return false;
	}

}
