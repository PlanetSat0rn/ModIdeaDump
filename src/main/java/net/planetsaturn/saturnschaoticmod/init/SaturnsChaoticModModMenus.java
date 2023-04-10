
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.planetsaturn.saturnschaoticmod.init;

import net.planetsaturn.saturnschaoticmod.world.inventory.TimeControllerUIMenu;
import net.planetsaturn.saturnschaoticmod.SaturnsChaoticModMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class SaturnsChaoticModModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SaturnsChaoticModMod.MODID);
	public static final RegistryObject<MenuType<TimeControllerUIMenu>> TIME_CONTROLLER_UI = REGISTRY.register("time_controller_ui", () -> IForgeMenuType.create(TimeControllerUIMenu::new));
}
