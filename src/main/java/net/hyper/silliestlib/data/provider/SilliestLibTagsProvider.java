package net.hyper.silliestlib.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.material.Fluid;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("NullableProblems")
public abstract class SilliestLibTagsProvider {
    public static abstract class BannerPatternTagsProvider extends FabricTagsProvider<BannerPattern> {
        public BannerPatternTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.BANNER_PATTERN, registryLookupFuture);
        }
        @Override protected abstract void addTags(HolderLookup.Provider registries);
    }
    public static abstract class BiomeTagsProvider extends FabricTagsProvider<Biome> {
        public BiomeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.BIOME, registryLookupFuture);
        }
        @Override protected abstract void addTags(HolderLookup.Provider registries);
    }
    public static abstract class DamageTypeTagsProvider extends FabricTagsProvider<DamageType> {
        public DamageTypeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.DAMAGE_TYPE, registryLookupFuture);
        }
        @Override protected abstract void addTags(HolderLookup.Provider registries);
    }
    public static abstract class EnchantmentTagsProvider extends FabricTagsProvider<Enchantment> {
        public EnchantmentTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.ENCHANTMENT, registryLookupFuture);
        }
        @Override protected abstract void addTags(HolderLookup.Provider registries);
    }
    public static abstract class FluidTagsProvider extends FabricTagsProvider<Fluid> {
        public FluidTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.FLUID, registryLookupFuture);
        }
        @Override protected abstract void addTags(HolderLookup.Provider registries);
    }
    public static abstract class ConfiguredFeatureTagsProvider extends FabricTagsProvider<ConfiguredFeature<?, ?>> {
        public ConfiguredFeatureTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.CONFIGURED_FEATURE, registryLookupFuture);
        }
        @Override protected abstract void addTags(HolderLookup.Provider registries);
    }
    public static abstract class GameEventTagsProvider extends FabricTagsProvider<GameEvent> {
        public GameEventTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.GAME_EVENT, registryLookupFuture);
        }
        @Override protected abstract void addTags(HolderLookup.Provider registries);
    }
    public static abstract class InstrumentTagsProvider extends FabricTagsProvider<Instrument> {
        public InstrumentTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.INSTRUMENT, registryLookupFuture);
        }
        @Override protected abstract void addTags(HolderLookup.Provider registries);
    }
    public static abstract class PaintingVariantTagsProvider extends FabricTagsProvider<PaintingVariant> {
        public PaintingVariantTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.PAINTING_VARIANT, registryLookupFuture);
        }
        @Override protected abstract void addTags(HolderLookup.Provider registries);
    }
    public static abstract class PoiTypeTagsProvider extends FabricTagsProvider<PoiType> {
        public PoiTypeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.POINT_OF_INTEREST_TYPE, registryLookupFuture);
        }
        @Override protected abstract void addTags(HolderLookup.Provider registries);
    }
    public static abstract class StructureTagsProvider extends FabricTagsProvider<Structure> {
        public StructureTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.STRUCTURE, registryLookupFuture);
        }
        @Override protected abstract void addTags(HolderLookup.Provider registries);
    }
    public static abstract class VillagerTradeTagsProvider extends FabricTagsProvider<VillagerTrade> {
        public VillagerTradeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.VILLAGER_TRADE, registryLookupFuture);
        }
        @Override protected abstract void addTags(HolderLookup.Provider registries);
    }
}
