
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.planetsaturn.saturnschaoticmod.init;

import net.planetsaturn.saturnschaoticmod.item.ShotgunItem;
import net.planetsaturn.saturnschaoticmod.item.BulletItem;
import net.planetsaturn.saturnschaoticmod.SaturnsChaoticModMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

public class SaturnsChaoticModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SaturnsChaoticModMod.MODID);
	public static final RegistryObject<Item> SHOTGUN = REGISTRY.register("shotgun", () -> new ShotgunItem());
	public static final RegistryObject<Item> BULLET = REGISTRY.register("bullet", () -> new BulletItem());
	public static final RegistryObject<Item> WAR_TERMINAL = block(SaturnsChaoticModModBlocks.WAR_TERMINAL, SaturnsChaoticModModTabs.TAB_WAR);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
