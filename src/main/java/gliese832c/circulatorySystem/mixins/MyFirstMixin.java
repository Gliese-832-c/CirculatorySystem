/*package gliese832c.circulatorySystem.mixins;

import gliese832c.circulatorySystem.util.CirculatoryLogger;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityItem.class)
public class MyFirstMixin {

    @Inject(at = @At("HEAD"), method = "attackEntityFrom(Lnet/minecraft/util/DamageSource;F)Z", cancellable = true)
    private void attackEntityFrom(DamageSource source, float amount, CallbackInfoReturnable<Boolean> callback) {

        for (EntityPlayer player : ((EntityItem)(Object)this).world.playerEntities) {
            player.sendMessage(new TextComponentString("Test lmao - " + ((EntityItem)(Object)this).world.getTotalWorldTime()));
        }

        CirculatoryLogger.error("log test");

        callback.setReturnValue(false);
    }
}
*/