package werty.softhardcore.main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemHeartEmpty extends Item
{
    public ItemHeartEmpty()
    {
        this.setMaxStackSize(1);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if(NBTHelper.getPersistedPlayerTag(playerIn).getBoolean("ghost") && !Config.ghostFillHeart)
        {
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getHeldItem(hand));
        } else
        {
            if(playerIn.experienceLevel >= Config.healthXP)
            {
                playerIn.experienceLevel -= Config.healthXP;
                playerIn.getHeldItem(hand).shrink(1);
                if(Config.fillEffects)
                {
                    if(!worldIn.isRemote)
                    {
                        playerIn.sendStatusMessage(new TextComponentString("You feel weak after transfering energy to the crystal"), true);
                    }
                    playerIn.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, Config.sicknessTicks, 1, false, false));//weakness
                }
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, new ItemStack(SHItems.heartFull));
            }
        }
        return new ActionResult(EnumActionResult.FAIL, playerIn.getHeldItem(hand));

    }
}
