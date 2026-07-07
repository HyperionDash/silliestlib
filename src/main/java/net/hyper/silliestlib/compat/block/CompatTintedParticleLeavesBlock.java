package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.TintedParticleLeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.List;

public class CompatTintedParticleLeavesBlock extends TintedParticleLeavesBlock {
    public final List<String> MODIDS;
    public CompatTintedParticleLeavesBlock(String modId, float leafParticleChance, BlockBehaviour.Properties properties) {
        super(leafParticleChance, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}