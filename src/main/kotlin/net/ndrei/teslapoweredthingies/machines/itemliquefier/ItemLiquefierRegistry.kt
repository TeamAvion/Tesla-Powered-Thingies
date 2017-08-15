package net.ndrei.teslapoweredthingies.machines.itemliquefier

import net.minecraft.item.crafting.IRecipe
import net.minecraftforge.fml.common.discovery.ASMDataTable
import net.minecraftforge.registries.IForgeRegistry
import net.ndrei.teslacorelib.annotations.IRegistryHandler
import net.ndrei.teslacorelib.annotations.RegistryHandler
import net.ndrei.teslapoweredthingies.config.readExtraRecipesFile
import net.ndrei.teslapoweredthingies.config.readFluidStack
import net.ndrei.teslapoweredthingies.config.readItemStack

@RegistryHandler
object ItemLiquefierRegistry : IRegistryHandler {
    override fun registerRecipes(asm: ASMDataTable, registry: IForgeRegistry<IRecipe>) {
        LiquefierRecipes.registerRecipes()

        readExtraRecipesFile(ItemLiquefierBlock.registryName!!.resourcePath) { json ->
            val input = json.readItemStack("input_stack") ?: return@readExtraRecipesFile
            val output = json.readFluidStack("output_fluid") ?: return@readExtraRecipesFile

            LiquefierRecipes.recipes.add(
                    LiquefierRecipe(input, output)
            )
        }
    }
}
