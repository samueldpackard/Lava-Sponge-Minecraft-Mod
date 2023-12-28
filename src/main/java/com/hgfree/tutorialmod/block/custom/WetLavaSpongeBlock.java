package com.hgfree.tutorialmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;

import java.util.function.ToIntFunction;

public class WetLavaSpongeBlock extends Block {
    public WetLavaSpongeBlock(Settings settings) {
        super(settings
                .luminance(createLightLevelGetter(15)) // This should set the emitted light level
        );
    }

    private static ToIntFunction<BlockState> createLightLevelGetter(int lightLevel) {
        // Add a print statement here to confirm the light level is being set
//        System.out.println("Setting light level to: " + lightLevel);
        return (state) -> lightLevel; // Always returns the specified light level
    }

    // Other properties and abilities will be added here
}
