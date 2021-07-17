package wtf.bwdy.mudstone.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Shadow int count;
    //change NBT datatype
    @Redirect(method = "writeNbt", at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/NbtCompound;putByte(Ljava/lang/String;B)V"))
    private void modWriteNbt(NbtCompound nbt, String field, byte b) {
        nbt.putShort("Count", (short) count);
    }
    @Redirect(method = "<init>(Lnet/minecraft/nbt/NbtCompound;)V", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/nbt/NbtCompound;getByte(Ljava/lang/String;)B"))
    private void modReadNbt(ItemStack itemStack, int val) {
        count = 1;//tag.getShort("Count");
    }
}
