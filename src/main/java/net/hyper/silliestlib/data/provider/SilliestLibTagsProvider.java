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
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class SilliestLibTagsProvider {
    public static class BannerPatternTagsProvider extends FabricTagsProvider<BannerPattern> {
        public BannerPatternTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.BANNER_PATTERN, registryLookupFuture);
        }
        @Override protected void addTags(HolderLookup.@NonNull Provider registries) {}
    }
    public static class BiomeTagsProvider extends FabricTagsProvider<Biome> {
        public BiomeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.BIOME, registryLookupFuture);
        }
        @Override protected void addTags(HolderLookup.@NonNull Provider registries) {}
    }
    public static class DamageTypeTagsProvider extends FabricTagsProvider<DamageType> {
        public DamageTypeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.DAMAGE_TYPE, registryLookupFuture);
        }
        @Override protected void addTags(HolderLookup.@NonNull Provider registries) {}
    }
    public static class EnchantmentTagsProvider extends FabricTagsProvider<Enchantment> {
        public EnchantmentTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.ENCHANTMENT, registryLookupFuture);
        }
        @Override protected void addTags(HolderLookup.@NonNull Provider registries) {}
    }
    public static class ConfiguredFeatureTagsProvider extends FabricTagsProvider<ConfiguredFeature<?, ?>> {
        public ConfiguredFeatureTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.CONFIGURED_FEATURE, registryLookupFuture);
        }
        @Override protected void addTags(HolderLookup.@NonNull Provider registries) {}
    }
    public static class GameEventTagsProvider extends FabricTagsProvider<GameEvent> {
        public GameEventTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.GAME_EVENT, registryLookupFuture);
        }
        @Override protected void addTags(HolderLookup.@NonNull Provider registries) {}
    }
    public static class InstrumentTagsProvider extends FabricTagsProvider<Instrument> {
        public InstrumentTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.INSTRUMENT, registryLookupFuture);
        }
        @Override protected void addTags(HolderLookup.@NonNull Provider registries) {}
    }
    public static class PaintingVariantTagsProvider extends FabricTagsProvider<PaintingVariant> {
        public PaintingVariantTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.PAINTING_VARIANT, registryLookupFuture);
        }
        @Override protected void addTags(HolderLookup.@NonNull Provider registries) {}
    }
    public static class PoiTypeTagsProvider extends FabricTagsProvider<PoiType> {
        public PoiTypeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.POINT_OF_INTEREST_TYPE, registryLookupFuture);
        }
        @Override protected void addTags(HolderLookup.@NonNull Provider registries) {}
    }
    public static class StructureTagsProvider extends FabricTagsProvider<Structure> {
        public StructureTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.STRUCTURE, registryLookupFuture);
        }
        @Override protected void addTags(HolderLookup.@NonNull Provider registries) {}
    }
    public static class VillagerTradeTagsProvider extends FabricTagsProvider<VillagerTrade> {
        public VillagerTradeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
            super(output, Registries.VILLAGER_TRADE, registryLookupFuture);
        }
        @Override protected void addTags(HolderLookup.@NonNull Provider registries) {}
    }
}
