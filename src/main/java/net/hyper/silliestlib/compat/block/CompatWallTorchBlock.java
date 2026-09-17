package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.WallTorchBlock;

import java.util.List;

public class CompatWallTorchBlock extends WallTorchBlock {
    public final List<String> MODIDS;
    public CompatWallTorchBlock(String modId, SimpleParticleType flameParticle, Properties properties) {
        super(flameParticle, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
