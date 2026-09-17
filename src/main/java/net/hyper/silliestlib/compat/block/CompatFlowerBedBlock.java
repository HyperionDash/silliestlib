package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.FlowerBedBlock;

import java.util.List;

public class CompatFlowerBedBlock extends FlowerBedBlock {
    public final List<String> MODIDS;
    public CompatFlowerBedBlock(String modId, Properties properties, int shapeHeight) {
        super(properties, shapeHeight);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
