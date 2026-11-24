package net.hyper.silliestlib.content.item;

import net.hyper.silliestlib.content.component.ArmPoseOverrideComponent;
import net.hyper.silliestlib.init.SilliestLibDataComponents;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class DoubleHandedItem extends Item {
    public DoubleHandedItem(Properties properties) {
        super(properties.component(SilliestLibDataComponents.ARM_POSE_OVERRIDE, new ArmPoseOverrideComponent(HumanoidModel.ArmPose.CROSSBOW_CHARGE, false)));
    }
    public DoubleHandedItem(HumanoidModel.ArmPose armPose, Properties properties) {
        super(properties.component(SilliestLibDataComponents.ARM_POSE_OVERRIDE, new ArmPoseOverrideComponent(armPose, false)));
    }

    public InteractionResult overrideUse(Level level, Player player, InteractionHand hand) {
        return InteractionResult.FAIL;
    }
    public InteractionResult overrideUseOn(UseOnContext context) {
        return InteractionResult.FAIL;
    }
    public InteractionResult overrideInteractLivingEntity(ItemStack itemStack, Player player, LivingEntity target, InteractionHand type) {
        return InteractionResult.FAIL;
    }
    public InteractionResult overrideInteract(Player player, InteractionHand hand, Vec3 location) {
        return InteractionResult.FAIL;
    }
}
