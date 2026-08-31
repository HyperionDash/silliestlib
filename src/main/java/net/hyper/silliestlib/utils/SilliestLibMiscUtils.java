package net.hyper.silliestlib.utils;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.hyper.silliestlib.SilliestLib;
import net.minecraft.world.level.block.Block;

import static net.hyper.silliestlib.utils.SilliestLibRegUtils.getRK;

public interface SilliestLibMiscUtils {
    static void logIgniteAndBurnOdds(int igniteOdds, int burnOdds, Block block, Block baseBlock) {
        SilliestLib.LOGGER.debug("igniteOdds("+igniteOdds+") and burnOdds("+burnOdds+") for "+getRK(block).identifier()+" successfully copied from "+getRK(baseBlock).identifier());
    }
    static void addFlammableBlockFromExistingBlock(Block block, Block baseBlock) {
        int igniteOdds = FlammableBlockRegistry.getDefaultInstance().get(baseBlock).getIgniteOdds();
        int burnOdds = FlammableBlockRegistry.getDefaultInstance().get(baseBlock).getBurnOdds();
        FlammableBlockRegistry.getDefaultInstance().add(block, igniteOdds, burnOdds);
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) logIgniteAndBurnOdds(igniteOdds, burnOdds, block, baseBlock);
    }
    static void addFlammableBlockFromExistingBlock(Block instance, Block block, Block baseBlock) {
        int igniteOdds = FlammableBlockRegistry.getInstance(instance).get(baseBlock).getIgniteOdds();
        int burnOdds = FlammableBlockRegistry.getInstance(instance).get(baseBlock).getBurnOdds();
        FlammableBlockRegistry.getDefaultInstance().add(block, igniteOdds, burnOdds);
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) logIgniteAndBurnOdds(igniteOdds, burnOdds, block, baseBlock);
    }
}