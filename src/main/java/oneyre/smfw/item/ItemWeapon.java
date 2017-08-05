package oneyre.smfw.item;

import java.util.Collections;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class ItemWeapon extends ItemTool {
	protected ItemWeapon(float attack, float speed, Item.ToolMaterial material) {
		super(attack, speed, material, Collections.<Block>emptySet());
		maxStackSize = 1;
		setMaxDamage(material.getMaxUses());
	}
	
    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if ((double)state.getBlockHardness(worldIn, pos) != 0.0D)
        {
            stack.damageItem(2, entityLiving);
        }
        return true;
    }
    
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        return hitEffect(stack, target, attacker);
    }
    
    /**
     * Additional effects for hitting entities. Return true if hit is successful
     * @param stack item being used to hit the entity
     * @param target the target of the attack
     * @param attacker the attacker
     * @return success of the hit
     */
    protected abstract boolean hitEffect(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker);
}
