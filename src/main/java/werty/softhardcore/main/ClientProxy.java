package werty.softhardcore.main;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
    }

    @Override
    public void registerRenders()
    {
        SHItems.registerRender(SHItems.heartEmpty);
        SHItems.registerRender(SHItems.heartFull);

        SHBlocks.registerRender(SHBlocks.ghostAltar);
    }


    @Override
    public void openGUI(Object gui)
    {
        Minecraft.getMinecraft().displayGuiScreen((GuiScreen) gui);
    }
}
