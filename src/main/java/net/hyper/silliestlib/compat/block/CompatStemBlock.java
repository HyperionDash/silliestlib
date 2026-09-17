package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StemBlock;

import java.util.List;

public class CompatStemBlock extends StemBlock {
    public final List<String> MODIDS;
    public CompatStemBlock(String modId, ResourceKey<Block> fruit, ResourceKey<Block> attachedStem, ResourceKey<Item> seed, TagKey<Block> stemSupportBlocks, TagKey<Block> fruitSupportBlocks, Properties properties) {
        super(fruit, attachedStem, seed, stemSupportBlocks, fruitSupportBlocks, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
