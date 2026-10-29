package net.hyper.silliestlib.utils;

import com.google.common.collect.ImmutableSet;
import com.mojang.blaze3d.platform.InputConstants;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PoiHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.hyper.silliestlib.SilliestLib;
import net.minecraft.ChatFormatting;
import net.minecraft.client.KeyMapping;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stat;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Util;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public interface SilliestLibRegUtils {
    static Block regBlock(String id, Function<BlockBehaviour.Properties, Block> func, BlockBehaviour.Properties properties) {
        return Registry.register(BuiltInRegistries.BLOCK, SilliestLib.cid(id), func.apply(properties.setId(createResourceKey(Registries.BLOCK, id))));
    }
    static Block regBlock(String id, Function<BlockBehaviour.Properties, Block> func) {
        return regBlock(id, func, BlockBehaviour.Properties.of());
    }
    static void addFlammableBlockFromExistingBlock(Block instance, Block block, Block baseBlock) {
        int igniteOdds = FlammableBlockRegistry.getInstance(instance).get(baseBlock).getIgniteOdds();
        int burnOdds = FlammableBlockRegistry.getInstance(instance).get(baseBlock).getBurnOdds();
        FlammableBlockRegistry.getInstance(instance).add(block, igniteOdds, burnOdds);
        SilliestLib.LOGGER.debug("igniteOdds({}) and burnOdds({}) for {} successfully copied from {}", igniteOdds, burnOdds, BuiltInRegistries.BLOCK.getResourceKey(block).get().identifier(), BuiltInRegistries.BLOCK.getResourceKey(block).get().identifier());
    }
    static void addFlammableBlockFromExistingBlock(Block block, Block baseBlock) {
        addFlammableBlockFromExistingBlock(Blocks.FIRE, block, baseBlock);
    }
    static Item regItem(String id, Function<Item.Properties, Item> func, Item.Properties properties) {
        return Registry.register(BuiltInRegistries.ITEM, SilliestLib.cid(id), func.apply(properties.setId(createResourceKey(Registries.ITEM, id))));
    }
    static Item regItem(String id, Function<Item.Properties, Item> func) {
        return regItem(id, func, new Item.Properties());
    }
    static Item regBlockItem(String id, Function<Item.Properties, Item> func, Item.Properties properties) {
        return regItem(id, func, properties.useBlockDescriptionPrefix());
    }
    static Item regBlockItem(String id, Block block) {
        return regBlockItem(id, p -> new BlockItem(block, p), new Item.Properties());
    }
    static <T extends Entity> EntityType<T> regEntityType(String id, EntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, SilliestLib.cid(id), builder.build(createEntityTypeKey(id)));
    }
    static <T extends LivingEntity> EntityType<T> regEntityType(String id, EntityType.Builder<T> builder, AttributeSupplier.Builder attributeBuilder) {
        EntityType<T> type = regEntityType(id, builder);
        FabricDefaultAttributeRegistry.register(type, attributeBuilder);
        return type;
    }
    static <T extends BlockEntityType<?>> T regBlockEntityType(String id, T blockEntityType) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, SilliestLib.cid(id), blockEntityType);
    }
    static void addSupportedBlocks(BlockEntityType<?> type, Block... blocks) {
        for(Block block : blocks) type.addValidBlock(block);
    }
    static <T> DataComponentType<T> regDataComponentType(String id, UnaryOperator<DataComponentType.Builder<T>> builder) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, SilliestLib.cid(id), builder.apply(DataComponentType.builder()).build());
    }
    static Holder<MobEffect> regMobEffect(String id, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, SilliestLib.cid(id), effect);
    }
    static Holder<Potion> regPotion(String id, Potion potion) {
        return Registry.registerForHolder(BuiltInRegistries.POTION, SilliestLib.cid(id), potion);
    }
    static ParticleType<?> regParticleType(String id, ParticleType<?> particleType) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, SilliestLib.cid(id), particleType);
    }
    static SoundEvent regSoundEvent(String id) {
        return Registry.register(BuiltInRegistries.SOUND_EVENT, SilliestLib.cid(id), SoundEvent.createVariableRangeEvent(SilliestLib.cid(id)));
    }
    static Holder<SoundEvent> regSoundEventHolder(String id) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, SilliestLib.cid(id), SoundEvent.createVariableRangeEvent(SilliestLib.cid(id)));
    }
    static Holder.Reference<SoundEvent> regSoundEventHolderReference(String id) {
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, SilliestLib.cid(id), SoundEvent.createVariableRangeEvent(SilliestLib.cid(id)));
    }
    static Stat<?> regStat(String id, StatFormatter formatter) {
        return Stats.CUSTOM.get(Registry.register(BuiltInRegistries.CUSTOM_STAT, id, SilliestLib.cid(id)), formatter);
    }
    static Stat<?> regStat(String id) {
        return regStat(id, StatFormatter.DEFAULT);
    }
    static RecipeSerializer<Recipe<?>> regRecipeSerializer(String id, RecipeSerializer<Recipe<?>> recipeSerializer) {
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, SilliestLib.cid(id), recipeSerializer);
    }
    static VillagerProfession regVillagerProfession(String id, ResourceKey<PoiType> poi, SoundEvent sound, Int2ObjectMap<ResourceKey<TradeSet>> map) {
        return Registry.register(BuiltInRegistries.VILLAGER_PROFESSION, SilliestLib.cid(id), new VillagerProfession(Component.translatable("entity.minecraft.villager." + id), holder -> holder.is(poi), holder -> holder.is(poi), ImmutableSet.of(), ImmutableSet.of(), sound, map));
    }
    static PoiType regPoiType(String id, int ticketCount, int searchDistance, Block... block) {
        return PoiHelper.register(SilliestLib.cid(id), ticketCount, searchDistance, block);
    }
    static ResourceKey<PoiType> regPoiTypeKey(String id) {
        return createResourceKey(Registries.POINT_OF_INTEREST_TYPE, id);
    }
    static KeyMapping regKeyMapping(String id, InputConstants.Type type, int key, KeyMapping.Category category) {
        return KeyMappingHelper.registerKeyMapping(new KeyMapping("key."+SilliestLib.CURRENT_MOD_ID+"."+id, type, key, category));
    }
    static KeyMapping.Category regKeyMappingCategory(String id) {
        return KeyMapping.Category.register(SilliestLib.cid(id));
    }
    static ArmorMaterial createArmorMaterial(ResourceKey<EquipmentAsset> equipmentAsset, TagKey<Item> repairable, Holder<SoundEvent> equipSound, int durability, int bootsDefense, int legsDefense, int chestplateDefense, int helmetDefense, int bodyDefense, int enchantmentValue, int toughness, int knockbackResistance) {
        return new ArmorMaterial(durability, ArmorMaterials.makeDefense(bootsDefense, legsDefense, chestplateDefense, helmetDefense, bodyDefense), enchantmentValue, equipSound, toughness, knockbackResistance, repairable, equipmentAsset);
    }
    static ResourceKey<EquipmentAsset> createEquipmentAsset(String id) {
        return createResourceKey(EquipmentAssets.ROOT_ID, id);
    }
    static DamageSource createDamageSource(Level level, ResourceKey<DamageType> key) {
        return new DamageSource(level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(key));
    }
    static void regJukeboxSong(BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> key, Holder.Reference<SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput) {
        context.register(key, new JukeboxSong(soundEvent, Component.translatable(Util.makeDescriptionId("jukebox_song", key.identifier())), lengthInSeconds, comparatorOutput));
    }
    static void regPaintingVariant(final BootstrapContext<PaintingVariant> context, final ResourceKey<PaintingVariant> key, final int width, final int height, final boolean hasAuthor) {
        context.register(key, new PaintingVariant(width, height, key.identifier(), Optional.of(Component.translatable(key.identifier().toLanguageKey("painting", "title")).withStyle(ChatFormatting.YELLOW)), hasAuthor ? Optional.of(Component.translatable(key.identifier().toLanguageKey("painting", "author")).withStyle(ChatFormatting.GRAY)) : Optional.empty()));
    }
    static Holder.Reference<TradeSet> regTradeSet(final BootstrapContext<TradeSet> context, final ResourceKey<TradeSet> resourceKey, final TagKey<VillagerTrade> tradeTag, final NumberProvider numberProvider) {
        return context.register(resourceKey, new TradeSet(context.lookup(Registries.VILLAGER_TRADE).getOrThrow(tradeTag), numberProvider, false, Optional.of(resourceKey.identifier().withPrefix("trade_set/"))));
    }
    static Holder.Reference<TradeSet> regTradeSet(final BootstrapContext<TradeSet> context, final ResourceKey<TradeSet> resourceKey, final TagKey<VillagerTrade> tradeTag) {
        return regTradeSet(context, resourceKey, tradeTag, ConstantValue.exactly(2.0F));
    }
    static <T>ResourceKey <T> createResourceKey(ResourceKey<? extends Registry<T>> registry, String id) {
        return ResourceKey.create(registry, SilliestLib.cid(id));
    }
    static ResourceKey<BannerPattern> createBannerPatternKey(String id) {
        return createResourceKey(Registries.BANNER_PATTERN, id);
    }
    static ResourceKey<Biome> createBiomeKey(String id) {
        return createResourceKey(Registries.BIOME, id);
    }
    static ResourceKey<Block> createBlockKey(String id) {
        return createResourceKey(Registries.BLOCK, id);
    }
    static ResourceKey<BlockEntityType<?>> createBlockEntityTypeKey(String id) {
        return createResourceKey(Registries.BLOCK_ENTITY_TYPE, id);
    }
    static ResourceKey<ConfiguredFeature<?, ?>> createConfiguredFeatureKey(String id) {
        return createResourceKey(Registries.CONFIGURED_FEATURE, id);
    }
    static ResourceKey<CreativeModeTab> createCreativeModeTabKey(String id) {
        return createResourceKey(Registries.CREATIVE_MODE_TAB, id);
    }
    static ResourceKey<DamageType> createDamageTypeKey(String id) {
        return createResourceKey(Registries.DAMAGE_TYPE, id);
    }
    static ResourceKey<DataComponentType<?>> createDataComponentTypeKey(String id) {
        return createResourceKey(Registries.DATA_COMPONENT_TYPE, id);
    }
    static ResourceKey<Enchantment> createEnchantmentKey(String id) {
        return createResourceKey(Registries.ENCHANTMENT, id);
    }
    static ResourceKey<EntityType<?>> createEntityTypeKey(String id) {
        return createResourceKey(Registries.ENTITY_TYPE, id);
    }
    static ResourceKey<Fluid> createFluidKey(String id) {
        return createResourceKey(Registries.FLUID, id);
    }
    static ResourceKey<GameEvent> createGameEventKey(String id) {
        return createResourceKey(Registries.GAME_EVENT, id);
    }
    static ResourceKey<Instrument> createInstrumentKey(String id) {
        return createResourceKey(Registries.INSTRUMENT, id);
    }
    static ResourceKey<Item> createItemKey(String id) {
        return createResourceKey(Registries.ITEM, id);
    }
    static ResourceKey<PaintingVariant> createPaintingVariantKey(String id) {
        return createResourceKey(Registries.PAINTING_VARIANT, id);
    }
    static ResourceKey<PoiType> createPoiTypeKey(String id) {
        return createResourceKey(Registries.POINT_OF_INTEREST_TYPE, id);
    }
    static ResourceKey<Potion> createPotionKey(String id) {
        return createResourceKey(Registries.POTION, id);
    }
    static ResourceKey<Structure> createStructureKey(String id) {
        return createResourceKey(Registries.STRUCTURE, id);
    }
    static ResourceKey<VillagerTrade> createVillagerTradeKey(String id) {
        return createResourceKey(Registries.VILLAGER_TRADE, id);
    }
}
