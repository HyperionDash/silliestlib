package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.ColoredFallingBlock;

import java.util.List;

public class CompatColoredFallingBlock extends ColoredFallingBlock {
    public final List<String> MODIDS;
    public CompatColoredFallingBlock(String modId, ColorRGBA dustColor, Properties properties) {
        super(dustColor, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
