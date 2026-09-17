package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.SandBlock;

import java.util.List;

public class CompatSandBlock extends SandBlock {
    public final List<String> MODIDS;
    public CompatSandBlock(String modId, ColorRGBA dustColor, Properties properties) {
        super(dustColor, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
