package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CoralWallFanBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;

public class CompatCoralWallFanBlock extends CoralWallFanBlock {
    public final List<String> MODIDS;
    public CompatCoralWallFanBlock(String modId, Block deadBlock, BlockBehaviour.Properties properties) {
        super(deadBlock, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}