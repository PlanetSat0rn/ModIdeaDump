
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.planetsaturn.saturnschaoticmod.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class SaturnsChaoticModModTabs {
	public static CreativeModeTab TAB_WAR;

	public static void load() {
		TAB_WAR = new CreativeModeTab("tabwar") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(SaturnsChaoticModModItems.SHOTGUN.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
