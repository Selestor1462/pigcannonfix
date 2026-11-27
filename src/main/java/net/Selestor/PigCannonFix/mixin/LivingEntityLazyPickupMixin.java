package net.Selestor.PigCannonFix.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LivingEntityLazyPickupMixin {

    @ModifyExpressionValue(
        method = "isPushable",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/level/ServerLevel;isPositionEntityTicking(Lnet/minecraft/core/BlockPos;)Z"
        ),
        require = 1
    )
    private boolean pigCannonFix$ignoreLazyChunkCheck(boolean isEntityTicking) {
        return true;
    }
}
