package oneyre.lapisadditions;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LapisAdditions.MODID, version = LapisAdditions.VERSION)
public class LapisAdditions
{
    public static final String MODID = "lapisadditions";
    public static final String VERSION = "1.0";
	public static final CreativeTabs creativeTab = new LapisAdditonsCreativeTab("Lapis Additions");
    
	
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	LapisItems.registerItems();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    }
}
