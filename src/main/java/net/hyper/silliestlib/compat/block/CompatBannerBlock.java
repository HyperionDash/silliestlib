package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BannerBlock;

import java.util.List;

public class CompatBannerBlock extends BannerBlock {
    public final List<String> MODIDS;
    public CompatBannerBlock(String modId, DyeColor color, Properties properties) {
        super(color, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
