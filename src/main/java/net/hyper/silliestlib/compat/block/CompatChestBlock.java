package net.hyper.silliestlib.compat.block;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

import java.util.List;
import java.util.function.Supplier;

public class CompatChestBlock extends ChestBlock {
    public final List<String> MODIDS;
    public CompatChestBlock(String modId, Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntityType, SoundEvent openSound, SoundEvent closeSound, Properties properties) {
        super(blockEntityType, openSound, closeSound, properties);
        this.MODIDS = List.of(modId);
    }

    @Override
    public boolean isEnabled(FeatureFlagSet enabledFeatures) {
        return MODIDS.stream().allMatch(SilliestLib::isModLoaded);
    }
}
