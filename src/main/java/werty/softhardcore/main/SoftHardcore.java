package werty.softhardcore.main;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class SoftHardcore
{
    @Instance(References.MODID)
    public static SoftHardcore instance;

    @SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        Config.configInit(event);
        SHItems.init();
        SHBlocks.init();
        MinecraftForge.EVENT_BUS.register(new SHEventHandler());

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerRenders();
        proxy.init(event);
        //SHEventHandler.loadAllowedBlocksandItems();
        GameRegistry.registerWorldGenerator(new SHWorldGenHandler(), 0);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}