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
    static Block regBlock(BlockItemId id, Function<BlockBehaviour.Properties, Block> function) {
        return Registry.register(BuiltInRegistries.BLOCK, id.block(), function.apply(BlockBehaviour.Properties.of().setId(id.block())));
    }
    static ResourceKey<Block> regBlockId(String name) {
        return ResourceKey.create(Registries.BLOCK, SilliestLib.cid(name));
    }
    static Item regBlockItem(BlockItemId id, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, id.item(), function.apply(new Item.Properties().useBlockDescriptionPrefix().setId(id.item())));
    }
    static BlockItemId regBlockItemId(String blockName, String itemName) {
        return BlockItemId.create(SilliestLib.cid(blockName), SilliestLib.cid(itemName));
    }
    static BlockItemId regBlockItemId(final String name) {
        return regBlockItemId(name, name);
    }
    static Item regItem(ResourceKey<Item> key, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, key, function.apply(new Item.Properties().setId(key)));
    }
    static ResourceKey<Item> regItemId(final String name) {
        return ResourceKey.create(Registries.ITEM, SilliestLib.cid(name));
    }
    static <T extends Entity> EntityType<T> regEntityType(ResourceKey<EntityType<?>> key, EntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key.identifier(), builder.build(key));
    }
    static <T extends LivingEntity> EntityType<T> regEntityType(ResourceKey<EntityType<?>> key, EntityType.Builder<T> builder, AttributeSupplier.Builder attributeBuilder) {
        EntityType<T> type = regEntityType(key, builder);
        FabricDefaultAttributeRegistry.register(type, attributeBuilder);
        return type;
    }
    static <T extends EntitySubPredicate> Codec<T> regEntitySubPredicateType(String name, Codec<T> codec) {
        return Registry.register(BuiltInRegistries.ENTITY_SUB_PREDICATE_TYPE, SilliestLib.cid(name), codec);
    }
    static <T extends BlockEntityType<?>> T regBlockEntity(String name, T blockEntityType) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, SilliestLib.cid(name), blockEntityType);
    }
    static ResourceKey<EntityType<?>> regEntityTypeId(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, SilliestLib.cid(name));
    }
    static <T>DataComponentType<T> regComponent(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, SilliestLib.cid(name), builderOperator.apply(DataComponentType.builder()).build());
    }
    static Holder<MobEffect> regEffect(String name, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, SilliestLib.cid(name), effect);
    }
    static Holder<Potion> regPotion(String name, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, SilliestLib.cid(name), potion);
    }
    static void regPotionRecipe(Holder<Potion> input, Ingredient ingredient, Holder<Potion> output) {
        FabricPotionBrewingBuilder.BUILD.register(builder -> {builder.registerPotionRecipe(input, ingredient, output);});
    }
    static SimpleParticleType regParticle(String name, SimpleParticleType particleType) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, SilliestLib.cid(name), particleType);
    }
    static Holder.Reference<SoundEvent> regJukeboxSong(String name) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, SilliestLib.cid(name), SoundEvent.createVariableRangeEvent(SilliestLib.cid(name)));
    }
    static SoundEvent regSoundEvent(String name) {
        return Registry.register(BuiltInRegistries.SOUND_EVENT, SilliestLib.cid(name), SoundEvent.createVariableRangeEvent(SilliestLib.cid(name)));
    }
    static Holder<SoundEvent> regSoundEventHolder(String name) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, SilliestLib.cid(name), SoundEvent.createVariableRangeEvent(SilliestLib.cid(name)));
    }
    static Stat<?> regStat(String key, StatFormatter formatter) {
        return Stats.CUSTOM.get(Registry.register(BuiltInRegistries.CUSTOM_STAT, key, SilliestLib.cid(key)), formatter);
    }
    static RecipeSerializer<Recipe<?>> regRecipeSerializer(String name, RecipeSerializer<Recipe<?>> recipeSerializer) {
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, SilliestLib.cid(name), recipeSerializer);
    }
    static VillagerProfession regVillagerProfession(String name, VillagerProfession profession) {
        return Registry.register(BuiltInRegistries.VILLAGER_PROFESSION, SilliestLib.cid(name), profession);
    }
    static PoiType regPoi(String name, Block block, int ticketCount, int searchDistance) {
        ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, SilliestLib.cid(name));
        return PoiHelper.register(SilliestLib.cid(name), ticketCount, searchDistance, block);
    }
    static KeyMapping regKeybind(String name, InputConstants.Type type, int key, KeyMapping.Category category) {
        return KeyMappingHelper.registerKeyMapping(new KeyMapping(name, type, key, category));
    }
    static ArmorMaterial createArmorMaterial(String name, int boots, int legs, int chest, int helm, int body, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, TagKey<Item> repairIngredient) {
        ResourceKey<? extends Registry<EquipmentAsset>> registryKey = ResourceKey.createRegistryKey(Identifier.parse("equipment_asset"));
        ResourceKey<EquipmentAsset> armorKey = ResourceKey.create(registryKey, SilliestLib.cid(name));
        return new ArmorMaterial(28, makeDefense(boots, legs, chest, helm, body), enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, armorKey);
    }
    static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body));
    }
}