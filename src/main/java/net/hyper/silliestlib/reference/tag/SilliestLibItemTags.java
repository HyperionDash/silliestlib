package net.hyper.silliestlib.reference.tag;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static net.hyper.silliestlib.utils.SilliestLibTagUtils.createItemTag;

public interface SilliestLibItemTags {
    TagKey<Item> CAN_SWEEP_ATTACK = createItemTag("can_sweep_attack");
    TagKey<Item> HIDES_OFFHAND_STACK = createItemTag("hides_offhand_stack");
    TagKey<Item> STAYS_VISIBLE_IN_OFFHAND = createItemTag("stays_visible_in_offhand");
}
