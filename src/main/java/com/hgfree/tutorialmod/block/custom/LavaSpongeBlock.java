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

    private boolean absorbLavaAround(World world, BlockPos pos) {
        boolean absorbedAnyLava = false;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    BlockPos newPos = pos.add(dx, dy, dz);
                    BlockState blockState = world.getBlockState(newPos);
                    if (blockState.getBlock() == Blocks.LAVA) {
                        world.setBlockState(newPos, Blocks.AIR.getDefaultState(), 3);
                        absorbedAnyLava = true;
                    }
                }
            }
        }
        return absorbedAnyLava;
    }
}
