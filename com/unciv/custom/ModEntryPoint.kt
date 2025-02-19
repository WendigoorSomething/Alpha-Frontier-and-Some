package com.unciv.mod.custom

import com.unciv.ui.components.tilegroups.TileGroup

class ModEntryPoint {

    fun initializeMod() {
        val tileGroup = TileGroup() // Initialize your TileGroup appropriately
        val size = 1.0f // Set the appropriate size

        // Use the TileLayerInitializer to create a custom tile layer with your custom sprite class
        val tileLayerInitializer = TileLayerInitializer()
        val customTileLayer = tileLayerInitializer.createCustomTileLayer(tileGroup, size)

        // Perform any additional setup or configuration for your custom tile layer
        // ...
    }
}
