package net.hyper.silliestlib.content.item;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.NonNull;

public class HiddenItem extends Item {
    public HiddenItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isEnabled(@NonNull FeatureFlagSet enabledFeatures) {
        return false;
    }
}