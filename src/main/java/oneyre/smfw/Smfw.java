package oneyre.smfw;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import oneyre.smfw.entity.EntityFlyingShoge;
import oneyre.smfw.init.CraftingRecipes;
import oneyre.smfw.init.SmfwBlocks;
import oneyre.smfw.init.SmfwItems;
import oneyre.smfw.proxy.IProxy;

@Mod(modid = Smfw.MODID, version = Smfw.VERSION)
public class Smfw
{
    public static final String MODID = "smfw";
    public static final String VERSION = "1.0";
	public static final CreativeTabs creativeTab = new SmfwCreativeTab("smfw");
	
	public static final SmfwLogger logger = new SmfwLogger();
    
	@SidedProxy(clientSide = "oneyre.smfw.proxy.CombinedClientProxy", serverSide = "oneyre.smfw.proxy.ServerProxy")
	public static IProxy proxy;
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	logger.init(event.getModLog());
    	logger.info("PREINIT");
    	
    	SmfwItems.registerItems();
    	SmfwBlocks.registerBlocks();
    	proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	logger.info("INIT");
    	
    	CraftingRecipes.registerRecipes();
    	EntityRegistry.registerModEntity(new ResourceLocation(Smfw.MODID + ":flyingshoge"), EntityFlyingShoge.class, "Flying Shoge", 0, this, 25, 1, true);
//		MinecraftForge.EVENT_BUS.register(new PickupPig());
    	proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	logger.info("POSTINIT");
    	
    	proxy.postInit(event);
    }
    
    @EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
    	event.registerServerCommand(new ValueTweakerCommand());
	}
}
