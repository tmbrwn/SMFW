package oneyre.smfw.event;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.NeighborNotifyEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DoorActivateHandler {

	@SubscribeEvent
	public void onActivateDoor(NeighborNotifyEvent e) {
		BlockPos pos = e.getPos();
		World world = e.getWorld();
		
		if(!(world.getBlockState(pos).getBlock() instanceof BlockDoor)) return;
		
		IBlockState door = world.getBlockState(pos);
		if(door.getValue(BlockDoor.HALF) == BlockDoor.EnumDoorHalf.LOWER) {
			IBlockState stone = Blocks.STONE.getDefaultState();
			world.setBlockState(pos.down(), stone);
		}
		
	}
	
}
