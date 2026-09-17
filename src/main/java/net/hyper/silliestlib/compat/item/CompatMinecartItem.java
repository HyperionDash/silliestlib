package net.hyper.silliestlib.compat.item;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.MinecartItem;

import java.util.List;

public class CompatMinecartItem extends MinecartItem {
    public final List<String> MODIDS;
    public CompatMinecartItem(String modId, EntityType<? extends AbstractMinecart> type, Properties properties) {
        super(type, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
