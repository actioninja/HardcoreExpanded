package werty.softhardcore.main;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemHeartFull extends Item
{
    public ItemHeartFull()
    {
        this.maxStackSize = 1;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        playerIn.getHeldItem(hand).shrink(1);
        if(NBTHelper.getPersistedPlayerTag(playerIn).hasKey("ghost") && NBTHelper.getPersistedPlayerTag(playerIn).getBoolean("ghost"))
        {
            NBTHelper.getPersistedPlayerTag(playerIn).setBoolean("ghost", false);
            playerIn.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(Config.healthStarting);
            NBTHelper.getPersistedPlayerTag(playerIn).setDouble("health", playerIn.getMaxHealth());
            playerIn.sendStatusMessage(new TextComponentString("You have been brought back from the dead!"), true);
        } else
        {
            if(playerIn.getMaxHealth() < Config.healthMax)
            {
                playerIn.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(playerIn.getMaxHealth() + 2D);
                NBTHelper.getPersistedPlayerTag(playerIn).setDouble("health", playerIn.getMaxHealth());
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
    }
}
