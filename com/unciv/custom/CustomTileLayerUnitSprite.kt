package com.unciv.mod.custom

import com.badlogic.gdx.graphics.g2d.Batch
import com.unciv.UncivGame
import com.unciv.logic.civilization.Civilization
import com.unciv.logic.map.mapunit.MapUnit
import com.unciv.models.ruleset.unique.LocalUniqueCache
import com.unciv.ui.components.tilegroups.TileGroup
import com.unciv.ui.components.tilegroups.layers.TileLayerUnitSprite
import com.unciv.ui.images.ImageGetter

class CustomTileLayerUnitSprite(tileGroup: TileGroup, size: Float) : TileLayerUnitSprite(tileGroup, size) {

    override fun updateSlot(currentSlot: UnitSpriteSlot?, unit: MapUnit?, isShown: Boolean): UnitSpriteSlot? {
        var location = ""
        var nationName = ""

        if (unit != null && isShown && UncivGame.Current.settings.showPixelUnits) {
            location = strings.getUnitImageLocation(unit)
            nationName = "${unit.civ.civName}-"
        }

        if (currentSlot == null && location == "") return null // No-op - had none, has none
        if (currentSlot?.currentImageLocation == "$nationName$location") return currentSlot // No-op - had, has
        
        if (location == "" || !ImageGetter.imageExists(location)){
            currentSlot?.spriteGroup?.remove()
            return null
        } 
        
        val slot = currentSlot ?: UnitSpriteSlot()
            .apply { this@CustomTileLayerUnitSprite.addActor(spriteGroup) }
        slot.currentImageLocation = "$nationName$location"
        slot.spriteGroup.clear()

        val nation = unit!!.civ.nation
        val pixelUnitImages = ImageGetter.getLayeredImageColored(
            location,
            null,
            nation.getInnerColor(),
            nation.getOuterColor()
        )
        for (pixelUnitImage in pixelUnitImages) {
            slot.spriteGroup.addActor(pixelUnitImage)
            pixelUnitImage.setHexagonSize() // Treat this as A TILE, which gets overlayed on the base tile.

            // Check if the unit is the specific one that should be twice as long
            if (unit.name == "Battlestar Vehicle") {
                // Scale the image to be twice as long as a tile
                pixelUnitImage.setSize(pixelUnitImage.width * 2, pixelUnitImage.height * 2)
            }
        }
        return slot
    }
}
