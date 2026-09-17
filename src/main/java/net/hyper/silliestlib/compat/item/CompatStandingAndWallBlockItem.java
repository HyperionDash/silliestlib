package net.hyper.silliestlib.compat.item;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.core.Direction;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class CompatStandingAndWallBlockItem extends StandingAndWallBlockItem {
    public final List<String> MODIDS;
    public CompatStandingAndWallBlockItem(String modId, Block block, Block wallBlock, Direction attachmentDirection, Properties properties) {
        super(block, wallBlock, attachmentDirection, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
