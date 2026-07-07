package net.hyper.silliestlib.compat.item;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class CompatPlaceOnWaterBlockItem extends PlaceOnWaterBlockItem {
    public final List<String> MODIDS;
    public CompatPlaceOnWaterBlockItem(String modId, Block block, Item.Properties properties) {
        super(block, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}