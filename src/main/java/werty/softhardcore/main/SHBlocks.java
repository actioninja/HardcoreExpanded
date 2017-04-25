package werty.softhardcore.main;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SHBlocks
{
    public static Block ghostAltar;

    public static void init()
    {
        ghostAltar = new BlockAltar(Material.ROCK).setBlockUnbreakable().setUnlocalizedName("ghostAltar").setCreativeTab(CreativeTabs.MISC);
        ghostAltar.setRegistryName("ghostAltar");

        GameRegistry.register(ghostAltar);
    }

    public static void registerRender(Block block)
    {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(References.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
