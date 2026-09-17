package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.WeightedPressurePlateBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.List;

public class CompatWeightedPressurePlateBlock extends WeightedPressurePlateBlock {
    public final List<String> MODIDS;
    public CompatWeightedPressurePlateBlock(String modId, int maxWeight, BlockSetType type, Properties properties) {
        super(maxWeight, type, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
