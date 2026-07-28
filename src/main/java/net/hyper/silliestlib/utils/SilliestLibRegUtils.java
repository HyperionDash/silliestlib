package net.hyper.silliestlib.utils;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PoiHelper;
import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.hyper.silliestlib.SilliestLib;
import net.minecraft.advancements.predicates.entity.EntitySubPredicate;
import net.minecraft.client.KeyMapping;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface SilliestLibRegUtils {
    static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }
    static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }
    static ResourceKey<EntityType<?>> getRK(EntityType entityType) {
        return BuiltInRegistries.ENTITY_TYPE.getResourceKey(entityType).get();
    }

    static Block regBlock(BlockItemId id, Function<BlockBehaviour.Properties, Block> function) {
        return Registry.register(BuiltInRegistries.BLOCK, id.block(), function.apply(BlockBehaviour.Properties.of().setId(id.block())));
    }
    static Block regBlock(String id, Function<BlockBehaviour.Properties, Block> function) {
        return Registry.register(BuiltInRegistries.BLOCK, SilliestLib.cid(id), function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, SilliestLib.cid(id)))));
    }
    static ResourceKey<Block> regBlockId(String key) {
        return ResourceKey.create(Registries.BLOCK, SilliestLib.cid(key));
    }
    static Item regBlockItem(BlockItemId id, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, id.item(), function.apply(new Item.Properties().useBlockDescriptionPrefix().setId(id.item())));
    }
    static Item regSimpleBlockItem(BlockItemId id, Block block) {
        return regBlockItem(id, properties -> new BlockItem(block,properties));
    }
    static BlockItemId regBlockItemId(String blockId, String itemId) {
        return BlockItemId.create(SilliestLib.cid(blockId), SilliestLib.cid(itemId));
    }
    static BlockItemId regBlockItemId(final String id) {
        return regBlockItemId(id, id);
    }
    static Item regItem(ResourceKey<Item> key, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, key, function.apply(new Item.Properties().setId(key)));
    }
    static Item regItem(String id, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, SilliestLib.cid(id), function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, SilliestLib.cid(id)))));
    }
    static ResourceKey<Item> regItemId(final String key) {
        return ResourceKey.create(Registries.ITEM, SilliestLib.cid(key));
    }
    static <T extends Entity> EntityType<T> regEntityType(ResourceKey<EntityType<?>> key, EntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key.identifier(), builder.build(key));
    }
    static <T extends Entity> EntityType<T> regEntityType(String id, EntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, SilliestLib.cid(id), builder.build(ResourceKey.create(Registries.ENTITY_TYPE, SilliestLib.cid(id))));
    }
    static <T extends LivingEntity> EntityType<T> regEntityType(ResourceKey<EntityType<?>> key, EntityType.Builder<T> builder, AttributeSupplier.Builder attributeBuilder) {
        EntityType<T> type = regEntityType(key, builder);
        FabricDefaultAttributeRegistry.register(type, attributeBuilder);
        return type;
    }
    static <T extends LivingEntity> EntityType<T> regEntityType(String id, EntityType.Builder<T> builder, AttributeSupplier.Builder attributeBuilder) {
        EntityType<T> type = regEntityType(ResourceKey.create(Registries.ENTITY_TYPE, SilliestLib.cid(id)), builder);
        FabricDefaultAttributeRegistry.register(type, attributeBuilder);
        return type;
    }
    static <T extends EntitySubPredicate> Codec<T> regEntitySubPredicateType(String id, Codec<T> codec) {
        return Registry.register(BuiltInRegistries.ENTITY_SUB_PREDICATE_TYPE, SilliestLib.cid(id), codec);
    }
    static <T extends BlockEntityType<?>> T regBlockEntity(ResourceKey<BlockEntityType<?>> key, T blockEntityType) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, key.identifier(), blockEntityType);
    }
    static <T extends BlockEntityType<?>> T regBlockEntity(String id, T blockEntityType) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, SilliestLib.cid(id), blockEntityType);
    }
    static ResourceKey<EntityType<?>> regEntityTypeId(String key) {
        return ResourceKey.create(Registries.ENTITY_TYPE, SilliestLib.cid(key));
    }
    static <T>DataComponentType<T> regComponent(String id, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, SilliestLib.cid(id), builderOperator.apply(DataComponentType.builder()).build());
    }
    static Holder<MobEffect> regEffect(String id, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, SilliestLib.cid(id), effect);
    }
    static Holder<Potion> regPotion(String id, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, SilliestLib.cid(id), potion);
    }
    static void regPotionRecipe(Holder<Potion> input, Ingredient ingredient, Holder<Potion> output) {
        FabricPotionBrewingBuilder.BUILD.register(builder -> {builder.registerPotionRecipe(input, ingredient, output);});
    }
    static SimpleParticleType regParticle(String id, SimpleParticleType particleType) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, SilliestLib.cid(id), particleType);
    }
    static Holder.Reference<SoundEvent> regJukeboxSong(String id) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, SilliestLib.cid(id), SoundEvent.createVariableRangeEvent(SilliestLib.cid(id)));
    }
    static SoundEvent regSoundEvent(String id) {
        return Registry.register(BuiltInRegistries.SOUND_EVENT, SilliestLib.cid(id), SoundEvent.createVariableRangeEvent(SilliestLib.cid(id)));
    }
    static Holder<SoundEvent> regSoundEventHolder(String id) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, SilliestLib.cid(id), SoundEvent.createVariableRangeEvent(SilliestLib.cid(id)));
    }
    static Stat<?> regStat(String key, StatFormatter formatter) {
        return Stats.CUSTOM.get(Registry.register(BuiltInRegistries.CUSTOM_STAT, key, SilliestLib.cid(key)), formatter);
    }
    static RecipeSerializer<Recipe<?>> regRecipeSerializer(String id, RecipeSerializer<Recipe<?>> recipeSerializer) {
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, SilliestLib.cid(id), recipeSerializer);
    }
    static VillagerProfession regVillagerProfession(String id, VillagerProfession profession) {
        return Registry.register(BuiltInRegistries.VILLAGER_PROFESSION, SilliestLib.cid(id), profession);
    }
    static PoiType regPoi(String id, Block block, int ticketCount, int searchDistance) {
        ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, SilliestLib.cid(id));
        return PoiHelper.register(SilliestLib.cid(id), ticketCount, searchDistance, block);
    }
    static KeyMapping regKeybind(String id, InputConstants.Type type, int key, KeyMapping.Category category) {
        return KeyMappingHelper.registerKeyMapping(new KeyMapping(id, type, key, category));
    }
    static ArmorMaterial createArmorMaterial(String id, int boots, int legs, int chest, int helm, int body, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, TagKey<Item> repairIngredient) {
        ResourceKey<? extends Registry<EquipmentAsset>> registryKey = ResourceKey.createRegistryKey(Identifier.parse("equipment_asset"));
        ResourceKey<EquipmentAsset> armorKey = ResourceKey.create(registryKey, SilliestLib.cid(id));
        return new ArmorMaterial(28, makeDefense(boots, legs, chest, helm, body), enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, armorKey);
    }
    static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body));
    }
}