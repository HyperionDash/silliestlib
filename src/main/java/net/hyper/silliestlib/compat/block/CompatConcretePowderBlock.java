package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ConcretePowderBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;

public class CompatConcretePowderBlock extends ConcretePowderBlock {
    public final List<String> MODIDS;
    public CompatConcretePowderBlock(String modId, Block concrete, BlockBehaviour.Properties properties) {
        super(concrete, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}