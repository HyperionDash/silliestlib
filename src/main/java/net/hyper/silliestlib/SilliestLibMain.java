package net.hyper.silliestlib;

import net.fabricmc.api.ModInitializer;
import net.hyper.silliestlib.init.SilliestLibDataComponents;

public class SilliestLibMain implements ModInitializer {
    @Override
    public void onInitialize() {
        SilliestLib.init(SilliestLib.MOD_ID);
        SilliestLibDataComponents.init();
    }
}
