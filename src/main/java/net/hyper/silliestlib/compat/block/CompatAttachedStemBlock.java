package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class CompatAttachedStemBlock extends AttachedStemBlock {
    public final List<String> MODIDS;
    public CompatAttachedStemBlock(String modId, ResourceKey<Block> stem, ResourceKey<Block> fruit, ResourceKey<Item> seed, TagKey<Block> supportBlocks, Properties properties) {
        super(stem, fruit, seed, supportBlocks, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
