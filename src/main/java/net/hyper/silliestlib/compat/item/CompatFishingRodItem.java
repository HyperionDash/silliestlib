package net.hyper.silliestlib.compat.item;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item;

import java.util.List;

public class CompatFishingRodItem extends FishingRodItem {
    public final List<String> MODIDS;
    public CompatFishingRodItem(String modId, Item.Properties properties) {
        super(properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}