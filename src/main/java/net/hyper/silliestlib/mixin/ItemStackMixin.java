package net.hyper.silliestlib.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.hyper.silliestlib.content.item.DoubleHandedItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @WrapOperation(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;use(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/InteractionResult;"))
    private InteractionResult silliestlib$wrapUse(Item instance, Level level, Player player, InteractionHand interactionHand, Operation<InteractionResult> original) {
        if (player.getMainHandItem().getItem() instanceof DoubleHandedItem doubleHandedItem) {
            return doubleHandedItem.overrideUse(level, player, interactionHand);
        } else return original.call(instance, level, player, interactionHand);
    }
    @WrapOperation(method = "useOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;useOn(Lnet/minecraft/world/item/context/UseOnContext;)Lnet/minecraft/world/InteractionResult;"))
    private InteractionResult silliestlib$wrapUseOn(Item instance, UseOnContext useOnContext, Operation<InteractionResult> original) {
        if (useOnContext.getPlayer().getMainHandItem().getItem() instanceof DoubleHandedItem doubleHandedItem) {
            return doubleHandedItem.overrideUseOn(useOnContext);
        } else return original.call(instance, useOnContext);
    }
    @WrapOperation(method = "interactLivingEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;interactLivingEntity(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/InteractionResult;"))
    private InteractionResult silliestlib$wrapInteractLivingEntity(Item instance, ItemStack itemStack, Player player, LivingEntity target, InteractionHand type, Operation<InteractionResult> original) {
        if (player.getMainHandItem().getItem() instanceof DoubleHandedItem doubleHandedItem) {
            return doubleHandedItem.overrideInteractLivingEntity(itemStack, player, target, type);
        } else return original.call(instance, itemStack, player, target, type);
    }
}
