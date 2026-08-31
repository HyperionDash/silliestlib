package net.hyper.silliestlib.utils;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static net.hyper.silliestlib.utils.SilliestLibRegUtils.getRK;

public interface SilliestLibMiscUtils {
    static void addFlammableBlockFromExistingBlock(Block block, Block baseBlock) {
        addFlammableBlockFromExistingBlock(Blocks.FIRE, block, baseBlock);
    }
    static void addFlammableBlockFromExistingBlock(Block instance, Block block, Block baseBlock) {
        int igniteOdds = FlammableBlockRegistry.getInstance(instance).get(baseBlock).getIgniteOdds();
        int burnOdds = FlammableBlockRegistry.getInstance(instance).get(baseBlock).getBurnOdds();
        FlammableBlockRegistry.getDefaultInstance().add(block, igniteOdds, burnOdds);
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) SilliestLib.LOGGER.debug("igniteOdds("+igniteOdds+") and burnOdds("+burnOdds+") for "+getRK(block).identifier()+" successfully copied from "+getRK(baseBlock).identifier());
    }
}