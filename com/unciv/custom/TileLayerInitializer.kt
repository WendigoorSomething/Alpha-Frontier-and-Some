package com.unciv.mod.custom

import com.unciv.ui.components.tilegroups.TileGroup
import com.unciv.ui.components.tilegroups.layers.TileLayerUnitSprite

class TileLayerInitializer {

    fun createCustomTileLayer(tileGroup: TileGroup, size: Float): TileLayerUnitSprite {
        return CustomTileLayerUnitSprite(tileGroup, size)
    }
}
