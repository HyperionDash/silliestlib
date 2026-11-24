package net.hyper.silliestlib.init;

import net.hyper.silliestlib.content.component.ArmPoseOverrideComponent;
import net.minecraft.core.component.DataComponentType;

import static net.hyper.silliestlib.utils.SilliestLibRegUtils.regDataComponentType;

public interface SilliestLibDataComponents {
    DataComponentType<ArmPoseOverrideComponent> ARM_POSE_OVERRIDE = regDataComponentType("arm_pose_ovderride", builder -> builder.persistent(ArmPoseOverrideComponent.CODEC));

    static void init() {}
}
