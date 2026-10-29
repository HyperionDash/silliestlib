package net.hyper.silliestlib.utils;

import net.hyper.silliestlib.SilliestLib;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.material.Fluid;

public interface SilliestLibTagUtils {
    static <T> TagKey<T> createTagKey(ResourceKey<? extends Registry<T>> registry, String id) {
        return TagKey.create(registry, SilliestLib.cid(id));
    }
    static TagKey<BannerPattern> createBannerPatterTag(String id) {
        return createTagKey(Registries.BANNER_PATTERN, id);
    }
    static TagKey<Biome> createBiomeTag(String id) {
        return createTagKey(Registries.BIOME, id);
    }
    static TagKey<Block> createBlockTag(String id) {
        return createTagKey(Registries.BLOCK, id);
    }
    static TagKey<BlockEntityType<?>> createBlockEntityTypeTag(String id) {
        return createTagKey(Registries.BLOCK_ENTITY_TYPE, id);
    }
    static TagKey<ConfiguredFeature<?, ?>> createConfiguredFeatureTag(String id) {
        return createTagKey(Registries.CONFIGURED_FEATURE, id);
    }
    static TagKey<DamageType> createDamageTypeTag(String id) {
        return createTagKey(Registries.DAMAGE_TYPE, id);
    }
    static TagKey<Enchantment> createEnchantmentTag(String id) {
        return createTagKey(Registries.ENCHANTMENT, id);
    }
    static TagKey<EntityType<?>> createEntityTypeTag(String id) {
        return createTagKey(Registries.ENTITY_TYPE, id);
    }
    static TagKey<Fluid> createFluidTag(String id) {
        return createTagKey(Registries.FLUID, id);
    }
    static TagKey<GameEvent> createGameEventTag(String id) {
        return createTagKey(Registries.GAME_EVENT, id);
    }
    static TagKey<Instrument> createInstrumentTag(String id) {
        return createTagKey(Registries.INSTRUMENT, id);
    }
    static TagKey<Item> createItemTag(String id) {
        return createTagKey(Registries.ITEM, id);
    }
    static TagKey<PaintingVariant> createPaintingVariantTag(String id) {
        return createTagKey(Registries.PAINTING_VARIANT, id);
    }
    static TagKey<PoiType> createPoiTypeTag(String id) {
        return createTagKey(Registries.POINT_OF_INTEREST_TYPE, id);
    }
    static TagKey<Structure> createStructureTag(String id) {
        return createTagKey(Registries.STRUCTURE, id);
    }
    static TagKey<VillagerTrade> createVillagerTradeTag(String id) {
        return createTagKey(Registries.VILLAGER_TRADE, id);
    }
}
