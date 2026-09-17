package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FarmlandBlock;

import java.util.List;

public class CompatFarmlandBlock extends FarmlandBlock {
    public final List<String> MODIDS;
    public CompatFarmlandBlock(String modId, Block baseBlock, Properties properties) {
        super(baseBlock, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
