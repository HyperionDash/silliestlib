package net.hyper.silliestlib.content.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hyper.silliestlib.init.SilliestLibDataComponents;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.item.ItemStack;

public record ArmPoseOverrideComponent(HumanoidModel.ArmPose armPose, boolean applyInOffhand) {
    private static final boolean applyInOffhandDefault = true;

    public static ArmPoseOverrideComponent armPoseOverride(HumanoidModel.ArmPose armPose) {
        return new ArmPoseOverrideComponent(armPose, applyInOffhandDefault);
    }
    public static ArmPoseOverrideComponent getArmPoseOverrideData(ItemStack itemStack) {
        return itemStack.get(SilliestLibDataComponents.ARM_POSE_OVERRIDE);
    }

    private static final Codec<HumanoidModel.ArmPose> ARM_POSE_CODEC = Codec.STRING.comapFlatMap(name -> {
        try {
            return DataResult.success(HumanoidModel.ArmPose.valueOf(name.toUpperCase()));
        } catch (IllegalArgumentException exception) {
            return DataResult.error(() -> "Unknown arm pose: " + name);
        }}, pose -> pose.name().toUpperCase()
    );
    public static final Codec<ArmPoseOverrideComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ARM_POSE_CODEC.fieldOf("arm_pose").forGetter(ArmPoseOverrideComponent::armPose),
            Codec.BOOL.optionalFieldOf("apply_in_offhand", applyInOffhandDefault).forGetter(ArmPoseOverrideComponent::applyInOffhand)
    ).apply(instance, ArmPoseOverrideComponent::new));
}
