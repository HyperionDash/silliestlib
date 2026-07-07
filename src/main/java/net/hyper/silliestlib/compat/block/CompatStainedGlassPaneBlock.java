package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;

public class CompatStainedGlassPaneBlock extends StainedGlassPaneBlock {
    public final List<String> MODIDS;
    public CompatStainedGlassPaneBlock(String modId, DyeColor color, BlockBehaviour.Properties properties) {
        super(color, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}