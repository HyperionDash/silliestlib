package net.hyper.silliestlib.item;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;

public class HiddenItem extends Item {
    public HiddenItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return false;
    }
}