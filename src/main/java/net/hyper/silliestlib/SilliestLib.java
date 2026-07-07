package net.hyper.silliestlib;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.hyper.silliestlib.registry.SilliestLibDataComponents;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SilliestLib implements ModInitializer {
	public static final String MOD_ID = "silliestlib";
	public static String CURRENT_MOD_ID = "";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static void init(String modId) {
		CURRENT_MOD_ID = modId;
		if (CURRENT_MOD_ID != MOD_ID) {
			LOGGER.info("Loading SilliestLib for " + CURRENT_MOD_ID);
		}
	}
	public static Identifier cid(String path) {
		return Identifier.fromNamespaceAndPath(CURRENT_MOD_ID, path);
	}

	public static boolean isModLoaded(String modId) {
		return FabricLoader.getInstance().isModLoaded(modId);
	}

	@Override
	public void onInitialize() {
		init(MOD_ID);
		SilliestLibDataComponents.init();
	}
}