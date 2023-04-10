
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.planetsaturn.saturnschaoticmod.init;

import net.planetsaturn.saturnschaoticmod.block.WARTerminalBlock;
import net.planetsaturn.saturnschaoticmod.SaturnsChaoticModMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class SaturnsChaoticModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SaturnsChaoticModMod.MODID);
	public static final RegistryObject<Block> WAR_TERMINAL = REGISTRY.register("war_terminal", () -> new WARTerminalBlock());
}
