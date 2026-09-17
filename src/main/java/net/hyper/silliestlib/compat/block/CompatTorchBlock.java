package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.TorchBlock;

import java.util.List;

public class CompatTorchBlock extends TorchBlock {
    public final List<String> MODIDS;
    public CompatTorchBlock(String modId, SimpleParticleType flameParticle, Properties properties) {
        super(flameParticle, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
