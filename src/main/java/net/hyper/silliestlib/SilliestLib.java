package net.hyper.silliestlib;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SilliestLib {
	public static final String MOD_ID = "silliestlib";
	public static String CURRENT_MOD_ID = "fallback";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static void init(String modId, String displayName) {
		CURRENT_MOD_ID = modId;
		if (CURRENT_MOD_ID != MOD_ID) LOGGER.info("Loading SilliestLib for {}", displayName);
	}
	public static void init(String modId) {
		init(modId, modId);
	}
	public static Identifier cid(String path) {
		return Identifier.fromNamespaceAndPath(CURRENT_MOD_ID, path);
	}

	public static boolean isModLoaded(String modId) {
		return FabricLoader.getInstance().isModLoaded(modId);
	}
}
