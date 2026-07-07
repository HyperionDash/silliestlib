package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;

public class CompatDropExperienceBlock extends DropExperienceBlock {
    public final List<String> MODIDS;
    public CompatDropExperienceBlock(String modId, IntProvider xpRange, BlockBehaviour.Properties properties) {
        super(xpRange, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}