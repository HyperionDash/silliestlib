package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CoralPlantBlock;

import java.util.List;

public class CompatCoralPlantBlock extends CoralPlantBlock {
    public final List<String> MODIDS;
    public CompatCoralPlantBlock(String modId, Block deadBlock, Properties properties) {
        super(deadBlock, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
