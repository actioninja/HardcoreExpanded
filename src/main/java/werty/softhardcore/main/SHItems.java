package werty.softhardcore.main;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SHItems
{
    public static Item heartEmpty;
    public static Item heartFull;

    public static void init()
    {
        heartEmpty = new ItemHeartEmpty().setUnlocalizedName("heartEmpty").setCreativeTab(CreativeTabs.MISC);
        heartEmpty.setRegistryName("heartEmpty");
        heartFull = new ItemHeartFull().setUnlocalizedName("heartFull").setCreativeTab(CreativeTabs.MISC);
        heartFull.setRegistryName("heartFull");

        GameRegistry.register(heartEmpty);
        GameRegistry.register(heartFull);

        GameRegistry.addRecipe(new ItemStack(heartEmpty, 1), new Object[]{"D D", "DBD", " D ", 'D', Items.DIAMOND, 'B', Blocks.DIAMOND_BLOCK});
    }


    public static void registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(References.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
