package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.sounds.AmbientLeavesBlockSoundPlayer;

import java.util.List;

public class CompatLeavesBlock extends LeavesBlock {
    public final List<String> MODIDS;
    public CompatLeavesBlock(String modId, AmbientLeavesBlockSoundPlayer ambientLeavesBlockSoundPlayer, Properties properties) {
        super(ambientLeavesBlockSoundPlayer, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
