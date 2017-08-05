package oneyre.smfw.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemClub extends ItemWeapon {
	
	private static final float ATK_DMG = 4.0F;
	private static final float ATK_SPD = -3.0F;

    public ItemClub(Item.ToolMaterial material) {
    	super(ATK_DMG, ATK_SPD, material);
    }

    //TODO apply slow/daze to target
	@Override
	protected boolean hitEffect(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		return true;
	}
    
    

}
