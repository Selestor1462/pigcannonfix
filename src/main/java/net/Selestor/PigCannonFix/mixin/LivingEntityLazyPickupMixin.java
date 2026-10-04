package net.Selestor.PigCannonFix.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityLazyPickupMixin {

    private static boolean pigCannonFix$isLazy(LivingEntity entity) {
        return !entity.isAlwaysTicking()
            && entity.level() instanceof ServerLevel level
            && !level.isPositionEntityTicking(entity.blockPosition());
    }

    @Inject(
        method = "isPushable",
        at = @At("HEAD"),
        cancellable = true,
        require = 1
    )
    private void pigCannonFix$restoreLazyChunkPushability(CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (pigCannonFix$isLazy(self)
            && !self.isRemoved()
            && !self.isSpectator()
            && !self.onClimbable()) {
            cir.setReturnValue(true);
        }
    }
}