package com.hgfree.tutorialmod;

import com.hgfree.tutorialmod.block.ModBlocks;
import com.hgfree.tutorialmod.item.ModItemGroups;
import com.hgfree.tutorialmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		// Register Wet Lava Sponge as a fuel that burns for 800 ticks (40 seconds)
//		FuelRegistry.INSTANCE.add(ModBlocks.WET_LAVA_SPONGE, 800);
	}
}
