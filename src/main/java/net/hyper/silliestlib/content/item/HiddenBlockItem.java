package net.hyper.silliestlib.content.item;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

public class HiddenBlockItem extends BlockItem {
    public HiddenBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public boolean isEnabled(@NonNull FeatureFlagSet enabledFeatures) {
        return false;
    }
}
