package net.hyper.silliestlib.registry;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.util.Unit;

import static net.hyper.silliestlib.utils.SilliestLibRegUtils.*;

public interface SilliestLibDataComponents {
    DataComponentType<Unit> DOUBLE_HANDED = regComponent("double_handed",
            builder -> builder.persistent(Unit.CODEC).networkSynchronized(Unit.STREAM_CODEC));

    static void init() {}
}