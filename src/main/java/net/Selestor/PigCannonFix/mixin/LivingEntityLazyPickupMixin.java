package net.Selestor.PigCannonFix.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityLazyPickupMixin {

    @Inject(
        method = {
            "canInteractWithLevel",
            "canInteractWithWorld",
            "m_321151_",
            "method_60971"
        },
        at = @At("HEAD"),
        cancellable = true,
        require = 0
    )
    private void allowLazyChunkInteract(CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (!self.isRemoved()) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
        method = {
            "isPushable",
            "isCollidable",
            "m_6094_",
            "method_5863"
        },
        at = @At("HEAD"),
        cancellable = true,
        require = 0
    )
    private void forcePushableInLazyChunks(CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (!self.isRemoved() && !self.isSpectator()) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
        method = {
            "canBeRidden",
            "m_6060_",
            "method_5863"
        },
        at = @At("HEAD"),
        cancellable = true,
        require = 0
    )
    private void allowLazyCanBeRidden(Entity vehicle, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity self = (LivingEntity) (Object) this;
        if (!self.isRemoved()) {
            cir.setReturnValue(true);
        }
    }
}