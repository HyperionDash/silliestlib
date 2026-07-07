package net.hyper.silliestlib.compat.item;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.Item;

import java.util.List;

public class CompatHangingEntityItem extends HangingEntityItem {
    public final List<String> MODIDS;
    public CompatHangingEntityItem(String modId, EntityType<? extends HangingEntity> type, Item.Properties properties) {
        super(type, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}