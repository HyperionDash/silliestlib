package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.WaterloggedTransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;

public class CompatWaterloggedTransparentBlock extends WaterloggedTransparentBlock {
    public final List<String> MODIDS;
    public CompatWaterloggedTransparentBlock(String modId, BlockBehaviour.Properties properties) {
        super(properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}