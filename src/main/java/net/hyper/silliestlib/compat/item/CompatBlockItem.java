package net.hyper.silliestlib.compat.item;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class CompatBlockItem extends BlockItem {
    public final List<String> MODIDS;
    public CompatBlockItem(String modId, Block block, Properties properties) {
        super(block, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
