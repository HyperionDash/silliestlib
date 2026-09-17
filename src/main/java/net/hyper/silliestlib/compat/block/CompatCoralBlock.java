package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CoralBlock;

import java.util.List;

public class CompatCoralBlock extends CoralBlock {
    public final List<String> MODIDS;
    public CompatCoralBlock(String modId, Block deadBlock, Properties properties) {
        super(deadBlock, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
