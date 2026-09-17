package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.MossyCarpetBlock;

import java.util.List;

public class CompatMossyCarpetBlock extends MossyCarpetBlock {
    public final List<String> MODIDS;
    public CompatMossyCarpetBlock(String modId, Properties properties) {
        super(properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
