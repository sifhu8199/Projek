package com.pantek.lod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PantekLodMod implements ModInitializer {
    public static final String MOD_ID = "pantek_pfg";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("PANTEK PFG (Pipelined Frame Generator) Engine Initialized for Mali GPU!");
        LOGGER.info("Target Multiplier: 2x Frame Interpolation Active.");
    }
}
