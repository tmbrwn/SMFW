package oneyre.smfw.item;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import com.google.common.collect.Multimap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import oneyre.smfw.ValueTweaker;
import oneyre.smfw.Variable;

public class ItemClub extends Item {

    private final double attackDamage;
    private final double attackSpeed;
    private final Item.ToolMaterial material;
    Variable.Float strength;

    public ItemClub(Item.ToolMaterial material) {
    	this.material = material;
    	attackDamage = 5.0D + (double)material.getDamageVsEntity();
    	attackSpeed = -3.0D;
    	strength = ValueTweaker.put(material.toString() + "_club_str", 2F);
    }
    
    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
    	Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);
    	if (slot == EntityEquipmentSlot.MAINHAND) {
    		updateModifier(multimap, SharedMonsterAttributes.ATTACK_DAMAGE, ATTACK_DAMAGE_MODIFIER, attackDamage);
    		updateModifier(multimap, SharedMonsterAttributes.ATTACK_SPEED, ATTACK_SPEED_MODIFIER, attackSpeed);
    	}
    	return multimap;
    }
    
    /**
     * Modified from Choonster's in http://github.com/Choonster-Minecraft-Mods/TestMod3
     * @param modifierMultimap the map to modify
     * @param attribute the attribute to modify
     * @param id the id of the attribute
     * @param value the value to update to
     */
    private void updateModifier(Multimap<String, AttributeModifier> modifierMultimap, IAttribute attribute, UUID id, double value) {
    	// Get the modifiers for the specified attribute
		final Collection<AttributeModifier> modifiers = modifierMultimap.get(attribute.getName());

		// Find the modifier with the specified ID, if any
		final Optional<AttributeModifier> modifierOptional = modifiers.stream().filter(attributeModifier -> attributeModifier.getID().equals(id)).findFirst();

		if (modifierOptional.isPresent()) { // If it exists,
			final AttributeModifier modifier = modifierOptional.get();
			modifiers.remove(modifier); // Remove it
			modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), value, modifier.getOperation())); // Add the new modifier
		} else {
			modifiers.add(new AttributeModifier(id, attribute.getName(), value, 0));
		}
		
    }

    @Override
    public int getItemEnchantability()
    {
        return this.material.getEnchantability();
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
    
    //TODO implement rules for smashing blocks with a club
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
        return true;
    }
    
    @Override
    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        //TODO implement rules for smashing blocks with a club
    	return 1.5F;
    }
    
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        ItemStack mat = this.material.getRepairItemStack();
        if (!mat.isEmpty() && net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false)) return true;
        return super.getIsRepairable(toRepair, repair);
    }
    

}
