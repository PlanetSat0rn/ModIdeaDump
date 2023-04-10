
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.planetsaturn.saturnschaoticmod.init;

import net.planetsaturn.saturnschaoticmod.client.gui.TimeControllerUIScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SaturnsChaoticModModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(SaturnsChaoticModModMenus.TIME_CONTROLLER_UI.get(), TimeControllerUIScreen::new);
		});
	}
}
