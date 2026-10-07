package net.hyper.silliestlib.item;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class HiddenBlockItem extends BlockItem {
    public HiddenBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return false;
    }
}
