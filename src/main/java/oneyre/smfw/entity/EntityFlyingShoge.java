package oneyre.smfw.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import oneyre.smfw.Smfw;

public class EntityFlyingShoge extends Entity {

	private EntityPlayer thrower;
	private Entity hookedEntity;
	private ShogeState currentState;
	
	public EntityFlyingShoge(World worldIn, EntityPlayer player) {
		this(worldIn);
		thrower = player;
		currentState = ShogeState.FLYING;
	}
	
	public EntityFlyingShoge(World worldIn) {
		super(worldIn);
		thrower = null;
		setSize(0.5F, 0.5F);
	}
	
	public int retract() {
		return 0;
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {		
	}
	
	private enum ShogeState {
		FLYING, HOOKED
	}

}
