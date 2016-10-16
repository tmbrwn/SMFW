package oneyre.smfw;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import oneyre.smfw.init.CraftingRecipes;
import oneyre.smfw.init.SmfwItems;
import oneyre.smfw.proxy.IProxy;

@Mod(modid = Smfw.MODID, version = Smfw.VERSION)
public class Smfw
{
    public static final String MODID = "smfw";
    public static final String VERSION = "1.0";
	public static final CreativeTabs creativeTab = new SmfwCreativeTab("smfw");
	
	private Logger logger;
    
	@SidedProxy(clientSide = "oneyre.smfw.proxy.CombinedClientProxy", serverSide = "oneyre.smfw.proxy.ServerProxy")
	public static IProxy proxy;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	logger = event.getModLog();
    	logger.log(Level.INFO, "registering items");
    	
    	SmfwItems.registerItems();
    	proxy.preInit();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	logger.log(Level.INFO, "registering recipes");
    	CraftingRecipes.registerRecipes();
    	proxy.init();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	logger.log(Level.INFO, "Nothing here either");
    	proxy.postInit();
    }
}
