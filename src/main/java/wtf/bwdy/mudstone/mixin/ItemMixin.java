package wtf.bwdy.mudstone.mixin;

import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "Lnet/minecraft/item/Item;getMaxCount()I", at = @At("RETURN"), cancellable = true)
    private void injected(CallbackInfoReturnable<Integer> cir) {
        int m = cir.getReturnValue();
        cir.setReturnValue(m > 64 ? m : m > 16 ? 999 : m > 1 ? 99 : 1);
    }
}
