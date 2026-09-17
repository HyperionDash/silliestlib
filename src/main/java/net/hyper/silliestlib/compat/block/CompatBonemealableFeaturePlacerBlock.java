package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.BonemealableFeaturePlacerBlock;
import net.minecraft.world.level.levelgen.feature.Feature;

import java.util.List;

public class CompatBonemealableFeaturePlacerBlock extends BonemealableFeaturePlacerBlock {
    public final List<String> MODIDS;
    public CompatBonemealableFeaturePlacerBlock(String modId, ResourceKey<Feature> feature, Properties properties) {
        super(feature, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
