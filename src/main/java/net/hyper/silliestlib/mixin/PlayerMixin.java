package net.hyper.silliestlib.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.hyper.silliestlib.reference.tag.SilliestLibItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Player.class)
public class PlayerMixin {
    @WrapOperation(method = "isSweepAttack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/tags/TagKey;)Z"))
    private boolean silliestlib$wrapIsSweepAttack(ItemStack instance, TagKey<?> tagKey, Operation<Boolean> original) {
        return original.call(instance, tagKey) || instance.is(SilliestLibItemTags.CAN_SWEEP_ATTACK);
    }
}
