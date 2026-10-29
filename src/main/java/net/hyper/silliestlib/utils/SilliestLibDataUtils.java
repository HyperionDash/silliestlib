package net.hyper.silliestlib.utils;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public interface SilliestLibDataUtils {
    static void createStandaloneStairs(Block block, TextureMapping textureMapping, BlockModelGenerators blockModelGenerators) {
        final Identifier Stairs = ModelTemplates.STAIRS_STRAIGHT.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier innerStairs = ModelTemplates.STAIRS_INNER.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier outerStairs = ModelTemplates.STAIRS_OUTER.create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(
                BlockModelGenerators.createStairs(block,
                        plainVariant(innerStairs),
                        plainVariant(Stairs),
                        plainVariant(outerStairs)));
        blockModelGenerators.registerSimpleItemModel(block, Stairs);
    }
    static void createStandaloneStairs(Block block, Material texture, BlockModelGenerators blockModelGenerators) {
        createStandaloneStairs(block, (new TextureMapping()).put(TextureSlot.ALL, texture), blockModelGenerators);
    }
    static void createStandaloneStairs(Block block, Block texture, BlockModelGenerators blockModelGenerators) {
        createStandaloneStairs(block, TextureMapping.getBlockTexture(texture), blockModelGenerators);
    }
    static void createStandaloneSlab(Block block, Block fullBlock, TextureMapping textureMapping, BlockModelGenerators blockModelGenerators) {
        final Identifier slabBottom = ModelTemplates.SLAB_BOTTOM.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier slabTop = ModelTemplates.SLAB_TOP.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier doubleSlab = ModelTemplates.CUBE_ALL.getDefaultModelLocation(fullBlock);
        blockModelGenerators.blockStateOutput.accept(
                BlockModelGenerators.createSlab(block,
                        plainVariant(slabBottom),
                        plainVariant(slabTop),
                        plainVariant(doubleSlab)));
        blockModelGenerators.registerSimpleItemModel(block, slabBottom);
    }
    static void createStandaloneSlab(Block block, Block fullBlock, Material texture, BlockModelGenerators blockModelGenerators) {
        createStandaloneSlab(block, fullBlock, (new TextureMapping()).put(TextureSlot.ALL, texture), blockModelGenerators);
    }
    static void createStandaloneSlab(Block block, Block fullBlock, Block texture, BlockModelGenerators blockModelGenerators) {
        createStandaloneSlab(block, fullBlock, TextureMapping.getBlockTexture(texture), blockModelGenerators);
    }
    static void createStandaloneWall(Block block, TextureMapping textureMapping, BlockModelGenerators blockModelGenerators) {
        final Identifier wallPost = ModelTemplates.WALL_POST.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier wallSide = ModelTemplates.WALL_LOW_SIDE.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier wallSideTall = ModelTemplates.WALL_TALL_SIDE.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier wallInventory = ModelTemplates.WALL_INVENTORY.create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(
                BlockModelGenerators.createWall(block,
                        plainVariant(wallPost),
                        plainVariant(wallSide),
                        plainVariant(wallSideTall)));
        blockModelGenerators.registerSimpleItemModel(block, wallInventory);
    }
    static void createStandaloneWall(Block block, Material texture, BlockModelGenerators blockModelGenerators) {
        createStandaloneWall(block, (new TextureMapping()).put(TextureSlot.ALL, texture), blockModelGenerators);
    }
    static void createStandaloneWall(Block block, Block texture, BlockModelGenerators blockModelGenerators) {
        createStandaloneWall(block, TextureMapping.getBlockTexture(texture), blockModelGenerators);
    }
    static void createStandaloneFence(Block block, TextureMapping textureMapping, BlockModelGenerators blockModelGenerators) {
        final Identifier fencePost = ModelTemplates.FENCE_POST.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier fenceSide = ModelTemplates.FENCE_SIDE.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier fenceInventory = ModelTemplates.FENCE_INVENTORY.create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(
                BlockModelGenerators.createFence(block,
                        plainVariant(fencePost),
                        plainVariant(fenceSide)));
        blockModelGenerators.registerSimpleItemModel(block, fenceInventory);
    }
    static void createStandaloneFence(Block block, Material texture, BlockModelGenerators blockModelGenerators) {
        createStandaloneFence(block, (new TextureMapping()).put(TextureSlot.ALL, texture), blockModelGenerators);
    }
    static void createStandaloneFence(Block block, Block texture, BlockModelGenerators blockModelGenerators) {
        createStandaloneFence(block, TextureMapping.getBlockTexture(texture), blockModelGenerators);
    }
    static void createStandaloneFenceGate(Block block, TextureMapping textureMapping, BlockModelGenerators blockModelGenerators) {
        final Identifier fenceGate = ModelTemplates.FENCE_GATE_CLOSED.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier fenceGateWall = ModelTemplates.FENCE_GATE_WALL_CLOSED.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier fenceGateOpen = ModelTemplates.FENCE_GATE_OPEN.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier fenceGateWallOpen = ModelTemplates.FENCE_GATE_WALL_OPEN.create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(
                BlockModelGenerators.createFenceGate(block,
                        plainVariant(fenceGateOpen),
                        plainVariant(fenceGate),
                        plainVariant(fenceGateWallOpen),
                        plainVariant(fenceGateWall),true));
        blockModelGenerators.registerSimpleItemModel(block, fenceGate);
    }
    static void createStandaloneFenceGate(Block block, Material texture, BlockModelGenerators blockModelGenerators) {
        createStandaloneFenceGate(block, (new TextureMapping()).put(TextureSlot.ALL, texture), blockModelGenerators);
    }
    static void createStandaloneFenceGate(Block block, Block texture, BlockModelGenerators blockModelGenerators) {
        createStandaloneFenceGate(block, TextureMapping.getBlockTexture(texture), blockModelGenerators);
    }
    static void createStandalonePressurePlate(Block block, TextureMapping textureMapping, BlockModelGenerators blockModelGenerators) {
        final Identifier pressurePlate = ModelTemplates.PRESSURE_PLATE_UP.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier pressurePlateOn = ModelTemplates.PRESSURE_PLATE_DOWN.create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(
                BlockModelGenerators.createPressurePlate(block,
                        plainVariant(pressurePlate),
                        plainVariant(pressurePlateOn)));
        blockModelGenerators.registerSimpleItemModel(block, pressurePlate);
    }
    static void createStandalonePressurePlate(Block block, Material texture, BlockModelGenerators blockModelGenerators) {
        createStandalonePressurePlate(block, (new TextureMapping()).put(TextureSlot.ALL, texture), blockModelGenerators);
    }
    static void createStandalonePressurePlate(Block block, Block texture, BlockModelGenerators blockModelGenerators) {
        createStandalonePressurePlate(block, TextureMapping.getBlockTexture(texture), blockModelGenerators);
    }
    static void createStandaloneButton(Block block, TextureMapping textureMapping, BlockModelGenerators blockModelGenerators) {
        final Identifier button = ModelTemplates.BUTTON.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier buttonOn = ModelTemplates.BUTTON_PRESSED.create(block, textureMapping, blockModelGenerators.modelOutput);
        final Identifier buttonInventory = ModelTemplates.BUTTON_INVENTORY.create(block, textureMapping, blockModelGenerators.modelOutput);
        blockModelGenerators.blockStateOutput.accept(
                BlockModelGenerators.createButton(block,
                        plainVariant(button),
                        plainVariant(buttonOn)));
        blockModelGenerators.registerSimpleItemModel(block, buttonInventory);
    }
    static void createStandaloneButton(Block block, Material texture, BlockModelGenerators blockModelGenerators) {
        createStandaloneButton(block, (new TextureMapping()).put(TextureSlot.ALL, texture), blockModelGenerators);
    }
    static void createStandaloneButton(Block block, Block texture, BlockModelGenerators blockModelGenerators) {
        createStandaloneButton(block, TextureMapping.getBlockTexture(texture), blockModelGenerators);
    }
}
