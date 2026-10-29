package net.hyper.silliestlib.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class SilliestLibEquipmentAssetProvider implements DataProvider {
    private final FabricPackOutput.PathProvider pathProvider;
    private final FabricPackOutput output;

    public SilliestLibEquipmentAssetProvider(FabricPackOutput packOutput) {
        this.pathProvider = packOutput.createPathProvider(FabricPackOutput.Target.RESOURCE_PACK, "equipment");
        this.output = packOutput;
    }

    public void generateEquipmentAssets(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer) {}

    public EquipmentClientInfo onlyHumanoid(final String id) {
        return EquipmentClientInfo.builder().addHumanoidLayers(Identifier.fromNamespaceAndPath(output.getModId(), id)).build();
    }
    public EquipmentClientInfo humanoidAndMountArmor(final String id) {
        return EquipmentClientInfo.builder().addHumanoidLayers(Identifier.fromNamespaceAndPath(output.getModId(), id)).addLayers(EquipmentClientInfo.LayerType.HORSE_BODY, EquipmentClientInfo.Layer.leatherDyeable(Identifier.fromNamespaceAndPath(output.getModId(), id), false)).addLayers(EquipmentClientInfo.LayerType.NAUTILUS_BODY, new EquipmentClientInfo.Layer[]{EquipmentClientInfo.Layer.leatherDyeable(Identifier.fromNamespaceAndPath(output.getModId(), id), false)}).build();
    }

    @Override
    public @NonNull CompletableFuture<?> run(final @NonNull CachedOutput cache) {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> equipmentAssets = new HashMap<>();
        generateEquipmentAssets((id, asset) -> {
            if (equipmentAssets.putIfAbsent(id, asset) != null) {
                throw new IllegalStateException("Tried to register equipment asset twice for id: " + id);
            }
        });
        return DataProvider.saveAll(cache, EquipmentClientInfo.CODEC, this.pathProvider::json, equipmentAssets);
    }

    @Override
    public @NonNull String getName() {
        return "Equipment Asset Definitions";
    }
}
