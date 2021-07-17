package wtf.bwdy.mudstone.mixin;

import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Inventory.class)
interface InventoryMixin {
    @Inject(method = "Lnet/minecraft/inventory/Inventory;getMaxCountPerStack()I", at = @At("RETURN"), cancellable = true)
    private void injected(CallbackInfoReturnable<Integer> cir) {
        int m = cir.getReturnValue();
        cir.setReturnValue(m > 64 ? m : m > 16 ? 999 : m > 1 ? 99 : 1);
    }
}
