package com.hgfree.tutorialmod.block.custom;

import com.hgfree.tutorialmod.block.ModBlocks;
import net.minecraft.block.SpongeBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LavaSpongeBlock extends SpongeBlock {
    public LavaSpongeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!world.isClient) {
            boolean absorbedLava = absorbLavaAround(world, pos);
            if (absorbedLava) {
                world.setBlockState(pos, ModBlocks.WET_LAVA_SPONGE.getDefaultState(), 3);
            }
        }
    }

    private boolean absorbLavaAround(World world, BlockPos center) {
        boolean absorbedAnyLava = false;
        int radius = 7; // New radius
        int radiusSquared = radius * radius;

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -radius; dy <= radius; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    if (dx * dx + dy * dy + dz * dz <= radiusSquared) { // Check if within spherical radius
                        BlockPos currentPos = center.add(dx, dy, dz);
                        if (world.getBlockState(currentPos).getBlock() == Blocks.LAVA) {
                            world.setBlockState(currentPos, Blocks.AIR.getDefaultState(), 3); // Replace lava with air
                            absorbedAnyLava = true;
                        }
                    }
                }
            }
        }

        return absorbedAnyLava;
    }

}
