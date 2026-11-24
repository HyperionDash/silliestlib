package net.hyper.silliestlib.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.hyper.silliestlib.reference.tag.SilliestLibItemTags;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.layers.PlayerItemInHandLayer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.NonNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerItemInHandLayer.class)
public class PlayerItemInHandLayerMixin<S extends AvatarRenderState, M extends EntityModel<S> & ArmedModel<S> & HeadedModel> extends ItemInHandLayer<S, @NonNull M> {
    public PlayerItemInHandLayerMixin(RenderLayerParent<S, @NonNull M> renderer) {
        super(renderer);
    }

    @Unique
    public ItemStack getOffhandItemStack(S state) {
        return state.mainArm == HumanoidArm.RIGHT ? state.leftHandItemStack : state.rightHandItemStack;
    }

    @Inject(method = "submitArmWithItem(Lnet/minecraft/client/renderer/entity/state/AvatarRenderState;Lnet/minecraft/client/renderer/item/ItemStackRenderState;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/HumanoidArm;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;I)V", at = @At("HEAD"), cancellable = true)
    private void silliestlib$hideItem(S state, ItemStackRenderState item, ItemStack itemStack, HumanoidArm arm, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, CallbackInfo ci) {
        if (state.getMainHandItemStack().is(SilliestLibItemTags.HIDES_OFFHAND_STACK) && state.mainArm != arm && !getOffhandItemStack(state).is(SilliestLibItemTags.STAYS_VISIBLE_IN_OFFHAND)) {
            ci.cancel();
            return;
        }
        super.submitArmWithItem(state, item, itemStack, arm, poseStack, submitNodeCollector, lightCoords);
    }
}
