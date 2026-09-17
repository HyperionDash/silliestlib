package net.hyper.silliestlib.compat.item;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.FoodOnAStickItem;

import java.util.List;

@SuppressWarnings("unchecked")
public class CompatFoodOnAStickItem extends FoodOnAStickItem {
    public final List<String> MODIDS;
    public CompatFoodOnAStickItem(String modId, EntityType canInteractWith, int consumeItemDamage, Properties properties) {
        super(canInteractWith, consumeItemDamage, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
