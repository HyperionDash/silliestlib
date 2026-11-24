package net.hyper.silliestlib.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.hyper.silliestlib.content.item.DoubleHandedItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Mob.class)
public class MobMixin {
    @WrapOperation(method = "interact", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;interact(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/InteractionResult;"))
    private InteractionResult silliestlib$wrapMobInteract(Mob instance, Player player, InteractionHand interactionHand, Vec3 vec3, Operation<InteractionResult> original) {
        if (player.getMainHandItem().getItem() instanceof DoubleHandedItem doubleHandedItem) {
            return doubleHandedItem.overrideInteract(player, interactionHand, vec3);
        } else return original.call(instance, player, interactionHand, vec3);
    }
}
