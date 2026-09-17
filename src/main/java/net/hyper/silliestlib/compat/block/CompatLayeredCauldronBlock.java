package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.LayeredCauldronBlock;

import java.util.List;

public class CompatLayeredCauldronBlock extends LayeredCauldronBlock {
    public final List<String> MODIDS;
    public CompatLayeredCauldronBlock(String modId, Biome.Precipitation precipitationType, CauldronInteraction.Dispatcher interactionMap, Properties properties) {
        super(precipitationType, interactionMap, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
