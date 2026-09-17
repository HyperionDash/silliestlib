package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.InfestedBlock;

import java.util.List;

public class CompatInfestedBlock extends InfestedBlock {
    public final List<String> MODIDS;
    public CompatInfestedBlock(String modId, Block hostBlock, Properties properties) {
        super(hostBlock, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
