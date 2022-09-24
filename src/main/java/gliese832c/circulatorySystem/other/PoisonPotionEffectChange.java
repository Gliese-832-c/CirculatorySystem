/*package gliese832c.circulatorySystem.other;

import gliese832c.circulatorySystem.util.NBTHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PoisonPotionEffectChange {

    @SubscribeEvent
    public void onPotionAplied(PotionEvent.PotionApplicableEvent event) {
        if(event.getEntity().getEntityWorld().isRemote) {
            if(event.getEntity() instanceof EntityPlayer) {
                if(event.getPotionEffect().getPotion() == Potion.getPotionFromResourceLocation("minecraft:poison")) {
                    EntityPlayer player = (EntityPlayer) event.getEntity();
                    NBTHandler.setNBTdata(player, "liver", NBTHandler.getNBTdata(player, "liver") + 0.001);


                    event.setResult(Event.Result.DENY);
                }
            }
        }
    }
}
*/