package net.ndrei.teslapoweredthingies.common;

import net.ndrei.teslapoweredthingies.machines.FluidBurnerBlock;
import net.ndrei.teslapoweredthingies.machines.FluidSolidifierBlock;
import net.ndrei.teslapoweredthingies.machines.IncineratorBlock;
import net.ndrei.teslapoweredthingies.machines.ItemLiquefierBlock;

/**
 * Created by CF on 2017-01-06.
 */
public class BlocksRegistry {
    public static IncineratorBlock incinerator;
    public static FluidBurnerBlock fluidBurner;
    public static FluidSolidifierBlock fluidSolidifier;
    public static ItemLiquefierBlock itemLiquefierBlock;

    static void registerBlocks() {
        (BlocksRegistry.incinerator = new IncineratorBlock()).register();
        (BlocksRegistry.fluidBurner = new FluidBurnerBlock()).register();
        (BlocksRegistry.fluidSolidifier = new FluidSolidifierBlock()).register();
        (BlocksRegistry.itemLiquefierBlock = new ItemLiquefierBlock()).register();
    }
}
