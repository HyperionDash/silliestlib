package net.hyper.silliestlib.compat.item;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SolidBucketItem;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class CompatSolidBucketItem extends SolidBucketItem {
    public final List<String> MODIDS;
    public CompatSolidBucketItem(String modId, Block content, SoundEvent placeSound, Item.Properties properties) {
        super(content, placeSound, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}