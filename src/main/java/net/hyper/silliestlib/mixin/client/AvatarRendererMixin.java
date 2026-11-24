package net.hyper.silliestlib.mixin.client;

import net.hyper.silliestlib.content.component.ArmPoseOverrideComponent;
import net.hyper.silliestlib.init.SilliestLibDataComponents;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AvatarRenderer.class)
public abstract class AvatarRendererMixin {
    @Inject(method = "getArmPose(Lnet/minecraft/world/entity/Avatar;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/client/model/HumanoidModel$ArmPose;", at = @At("TAIL"), cancellable = true)
    private static void silliestlib$overrideArmPose(Avatar player, ItemStack stack, InteractionHand hand, CallbackInfoReturnable<HumanoidModel.ArmPose> cir) {
        ItemStack mainHandItem = player.getMainHandItem();
        ItemStack offhandItem = player.getOffhandItem();

        if (mainHandItem.has(SilliestLibDataComponents.ARM_POSE_OVERRIDE)) {
            cir.setReturnValue(ArmPoseOverrideComponent.getArmPoseOverrideData(mainHandItem).armPose());
        } else if (offhandItem.has(SilliestLibDataComponents.ARM_POSE_OVERRIDE) && ArmPoseOverrideComponent.getArmPoseOverrideData(offhandItem).applyInOffhand()) {
            cir.setReturnValue(ArmPoseOverrideComponent.getArmPoseOverrideData(offhandItem).armPose());
        }
    }
}