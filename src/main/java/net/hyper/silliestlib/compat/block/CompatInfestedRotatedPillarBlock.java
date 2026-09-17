package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.InfestedRotatedPillarBlock;

import java.util.List;

public class CompatInfestedRotatedPillarBlock extends InfestedRotatedPillarBlock {
    public final List<String> MODIDS;
    public CompatInfestedRotatedPillarBlock(String modId, Block hostBlock, Properties properties) {
        super(hostBlock, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
