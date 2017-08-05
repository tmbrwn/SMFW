package oneyre.smfw.item;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import oneyre.smfw.Smfw;
import oneyre.smfw.entity.EntityFlyingShoge;

public class ItemShoge extends ItemWeapon {
	
	private static final float ATK_DMG = 2.0F;
	private static final float ATK_SPD = -2.0F;
	
	private static final Map<EntityPlayer, EntityFlyingShoge> playerShoges = new HashMap<>();

	public ItemShoge(Item.ToolMaterial material) {
		super(ATK_DMG, ATK_SPD, material);
	}

	@Override
	protected boolean hitEffect(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		return true;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if(!worldIn.isRemote)
			Smfw.logger.info("right clicking!");
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		
		if(playerShoges.containsKey(playerIn)) {
			if(!worldIn.isRemote) {
				Smfw.logger.info("Found an existing shoge!");
				EntityFlyingShoge shoge = playerShoges.get(playerIn);
				int itemDamage = shoge.retract();
				itemstack.damageItem(itemDamage, playerIn);
				playerShoges.remove(playerIn);
			}
			playerIn.swingArm(handIn);
		}
		else  {
			if (!worldIn.isRemote){
				Smfw.logger.info("spawning shoge!");
				EntityFlyingShoge shoge = new EntityFlyingShoge(worldIn, playerIn);
				Vec3d looking = playerIn.getLookVec();
				Vec3d eyePosition = playerIn.getPositionEyes(1.0F);
				Vec3d spawnPoint = eyePosition.add(looking);
				float yaw = playerIn.rotationYawHead;
				float pitch = playerIn.rotationPitch;
				shoge.setLocationAndAngles(spawnPoint.xCoord, spawnPoint.yCoord, spawnPoint.zCoord, yaw, pitch);
				worldIn.spawnEntity(shoge);
				playerShoges.put(playerIn, shoge);
			}
			playerIn.swingArm(handIn);
	        playerIn.addStat(StatList.getObjectUseStats(this));
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
	
