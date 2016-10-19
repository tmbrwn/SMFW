package oneyre.smfw.block;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSmfwDoor extends BlockDoor {

	public BlockSmfwDoor(Material material) {
		super(material);
	}
	
	@Override
	public void toggleDoor(World worldIn, BlockPos pos, boolean open)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);

        if (iblockstate.getBlock() == this)
        {
            BlockPos blockpos = iblockstate.getValue(HALF) == BlockDoor.EnumDoorHalf.LOWER ? pos : pos.down();
            IBlockState activatedDoor = pos == blockpos ? iblockstate : worldIn.getBlockState(blockpos);

            if (activatedDoor.getBlock() == this && ((Boolean)activatedDoor.getValue(OPEN)).booleanValue() != open)
            {
                toggle(worldIn, activatedDoor, blockpos, open);
                IBlockState secondDoor = getDoubleDoor(worldIn, activatedDoor, blockpos);
                if(secondDoor != null) toggle(worldIn, secondDoor, blockpos, open);
            }
        }
    }
	
	private void toggle(World worldIn, IBlockState iblockstate1, BlockPos blockpos, boolean open) {
		worldIn.setBlockState(blockpos, iblockstate1.withProperty(OPEN, Boolean.valueOf(open)), 10);
        worldIn.markBlockRangeForRenderUpdate(blockpos, blockpos.up());
        worldIn.playEvent((EntityPlayer)null, open ? this.getOpenSound() : this.getCloseSound(), blockpos, 0);
	}
	
	private IBlockState getDoubleDoor(World worldIn, IBlockState firstDoor, BlockPos pos) {
		for(EnumFacing direction : EnumFacing.values()) {
			IBlockState secondDoor = getBlockInDirection(worldIn, pos, direction);
			if(secondDoor.getBlock() != this) continue;
			boolean facingSameWay = firstDoor.getValue(BlockDoor.FACING) == secondDoor.getValue(BlockDoor.FACING);
			boolean hingesOpposite = hingesFacing(firstDoor) == oppositeDirection(hingesFacing(secondDoor));
			if(facingSameWay && hingesOpposite) return secondDoor;
		}
		return null;
	
	}
	
	private IBlockState getBlockInDirection(World worldIn, BlockPos pos, EnumFacing direction) {
		switch(direction) {
		case NORTH:
			return worldIn.getBlockState(pos.north());
		case SOUTH:
			return worldIn.getBlockState(pos.south());
		case EAST:
			return worldIn.getBlockState(pos.east());
		case WEST:
			return worldIn.getBlockState(pos.west());
		default:
			return null;
		}
	}
	
	private EnumFacing oppositeDirection(EnumFacing direction) {
		switch(direction) {
		case NORTH:
			return EnumFacing.SOUTH;
		case SOUTH:
			return EnumFacing.NORTH;
		case EAST:
			return EnumFacing.WEST;
		case WEST:
			return EnumFacing.EAST;
		default:
			return null;
		}
	}
	
	/**
	 * state must be the IBlockState of a door
	 */
	private EnumFacing hingesFacing(IBlockState state) {
		EnumFacing NORTH = EnumFacing.NORTH;
		EnumFacing SOUTH = EnumFacing.SOUTH;
		EnumFacing EAST = EnumFacing.EAST;
		EnumFacing WEST = EnumFacing.WEST;
		
		BlockDoor.EnumHingePosition LEFT = BlockDoor.EnumHingePosition.LEFT;
		BlockDoor.EnumHingePosition hinge = state.getValue(BlockDoor.HINGE);
		switch(state.getValue(BlockDoor.FACING)) {
		case NORTH: 
			return hinge == LEFT ? WEST : EAST;
		case SOUTH:
			return hinge == LEFT ? EAST : WEST;
		case EAST:
			return hinge == LEFT ? NORTH : SOUTH;
		case WEST:
			return hinge == LEFT ? SOUTH : NORTH; 
		default:
			return null;
		}
	}
	
	/**
	 * From the BlockDoor class
	 * @return
	 */
	private int getCloseSound()
    {
        return this.blockMaterial == Material.IRON ? 1011 : 1012;
    }

    private int getOpenSound()
    {
        return this.blockMaterial == Material.IRON ? 1005 : 1006;
    }

}
