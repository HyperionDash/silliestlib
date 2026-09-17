package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.MangroveLeavesBlock;

import java.util.List;

public class CompatMangroveRootsBlock extends MangroveLeavesBlock {
    public final List<String> MODIDS;
    public CompatMangroveRootsBlock(String modId, float leafParticleChance, Properties properties) {
        super(leafParticleChance, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
