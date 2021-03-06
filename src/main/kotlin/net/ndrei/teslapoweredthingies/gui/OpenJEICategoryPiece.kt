package net.ndrei.teslapoweredthingies.gui

import net.minecraft.block.Block
import net.minecraft.client.renderer.GlStateManager
import net.ndrei.teslacorelib.gui.BasicTeslaGuiContainer
import net.ndrei.teslacorelib.gui.SideDrawerPiece
import net.ndrei.teslacorelib.inventory.BoundingRectangle
import net.ndrei.teslapoweredthingies.client.Textures
import net.ndrei.teslapoweredthingies.integrations.jei.TheJeiThing

/**
 * Created by CF on 2017-07-06.
 */
class OpenJEICategoryPiece(private val block: Block, topIndex: Int = 1) : SideDrawerPiece(topIndex) {
    override val isVisible: Boolean
        get() = TheJeiThing.isBlockRegistered(this.block)

    override fun renderState(container: BasicTeslaGuiContainer<*>, state: Int, box: BoundingRectangle) {
        // container.mc.textureManager.bindTexture(TeslaThingiesMod.MACHINES_TEXTURES)
        Textures.MACHINES_TEXTURES.bind(container)

        GlStateManager.enableBlend()
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA)
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f)
        container.drawTexturedModalRect(
                box.left, box.top + 1,
                81, 7,
                14, 14)
        GlStateManager.disableBlend()
    }

    override fun getStateToolTip(state: Int)
        = listOf("Open JEI")

    override fun clicked() {
        TheJeiThing.showCategory(this.block)
    }
}