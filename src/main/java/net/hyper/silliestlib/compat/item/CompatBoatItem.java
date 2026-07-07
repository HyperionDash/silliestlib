package net.hyper.silliestlib.compat.item;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.Item;

import java.util.List;

public class CompatBoatItem extends BoatItem {
    public final List<String> MODIDS;
    public CompatBoatItem(String modId, EntityType<? extends AbstractBoat> entityType, Item.Properties properties) {
        super(entityType, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}