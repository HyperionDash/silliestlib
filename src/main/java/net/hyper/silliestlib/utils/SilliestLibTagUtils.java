package net.hyper.silliestlib.utils;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.dialog.Dialog;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorPreset;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.timeline.Timeline;

public interface SilliestLibTagUtils {
    static TagKey<BannerPattern> createBannerPatternTag(String id, String name) {
        return TagKey.create(Registries.BANNER_PATTERN, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<Biome> createBiomeTag(String id, String name) {
        return TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<Block> createBlockTag(String id, String name) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<DamageType> createDamageTypeTag(String id, String name) {
        return TagKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<Dialog> createDialogTag(String id, String name) {
        return TagKey.create(Registries.DIALOG, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<Enchantment> createEnchantmentTag(String id, String name) {
        return TagKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<EntityType<?>> createEntityTypeTag(String id, String name) {
        return TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<ConfiguredFeature<?,?>> createFeatureTag(String id, String name) {
        return TagKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<FlatLevelGeneratorPreset> createFlatLevelGeneratorPresetTag(String id, String name) {
        return TagKey.create(Registries.FLAT_LEVEL_GENERATOR_PRESET, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<Fluid> createFluidTag(String id, String name) {
        return TagKey.create(Registries.FLUID, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<GameEvent> createGameEventTag(String id, String name) {
        return TagKey.create(Registries.GAME_EVENT, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<Instrument> createInstrumentTag(String id, String name) {
        return TagKey.create(Registries.INSTRUMENT, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<Item> createItemTag(String id, String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<PaintingVariant> createPaintingVariantTag(String id, String name) {
        return TagKey.create(Registries.PAINTING_VARIANT, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<PoiType> createPoiTypeTag(String id, String name) {
        return TagKey.create(Registries.POINT_OF_INTEREST_TYPE, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<Potion> createPotionTag(String id, String name) {
        return TagKey.create(Registries.POTION, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<Structure> createStructureTag(String id, String name) {
        return TagKey.create(Registries.STRUCTURE, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<Timeline> createTimelineTag(String id, String name) {
        return TagKey.create(Registries.TIMELINE, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<VillagerTrade> createVillagerTradeTag(String id, String name) {
        return TagKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(id, name));
    }
    static TagKey<WorldPreset> createWorldPresetTag(String id, String name) {
        return TagKey.create(Registries.WORLD_PRESET, Identifier.fromNamespaceAndPath(id, name));
    }
}