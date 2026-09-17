package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.UntintedParticleLeavesBlock;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;

import java.util.List;

public class CompatUntintedParticleLeavesBlock extends UntintedParticleLeavesBlock {
    public final List<String> MODIDS;
    public CompatUntintedParticleLeavesBlock(String modId, float leafParticleChance, ParticleOptions leafParticle, AmbientLeavesBlockSoundPlayer ambientLeavesBlockSoundPlayer, Properties properties) {
        super(leafParticleChance, leafParticle, ambientLeavesBlockSoundPlayer, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
