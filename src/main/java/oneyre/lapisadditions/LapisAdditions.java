package oneyre.lapisadditions;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import oneyre.lapisadditions.init.CraftingRecipes;
import oneyre.lapisadditions.init.LapisItems;
import oneyre.lapisadditions.proxy.IProxy;

@Mod(modid = LapisAdditions.MODID, version = LapisAdditions.VERSION)
public class LapisAdditions
{
    public static final String MODID = "lapisadditions";
    public static final String VERSION = "1.0";
	public static final CreativeTabs creativeTab = new LapisAdditonsCreativeTab("Lapis Additions");
	
	private Logger logger;
    
	@SidedProxy(clientSide = "oneyre.lapisadditions.proxy.CombinedClientProxy", serverSide = "oneyre.lapisadditions.proxy.ServerProxy")
	public static IProxy proxy;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	logger = event.getModLog();
    	logger.log(Level.INFO, "registering items");
    	
    	LapisItems.registerItems();
    	proxy.preInit();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	logger.log(Level.INFO, "registering recipes");
//    	CraftingRecipes.registerRecipes();
    	proxy.init();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	logger.log(Level.INFO, "Nothing here either");
    	proxy.postInit();
    }
}
