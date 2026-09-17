package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.WallSkullBlock;

import java.util.List;

public class CompatWallSkullBlock extends WallSkullBlock {
    public final List<String> MODIDS;
    public CompatWallSkullBlock(String modId, SkullBlock.Type type, Properties properties) {
        super(type, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
