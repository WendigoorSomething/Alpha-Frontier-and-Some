package com.unciv.mod.custom

import com.unciv.ui.components.tilegroups.TileGroup
import com.unciv.ui.components.tilegroups.layers.TileLayerUnitSprite

// This is an example initializer class for setting up tile layers in your mod
class TileLayerInitializer {

    fun createCustomTileLayer(tileGroup: TileGroup, size: Float): TileLayerUnitSprite {
        // Return an instance of your custom TileLayerUnitSprite
        return CustomTileLayerUnitSprite(tileGroup, size)
    }
}
