package net.planetsaturn.saturnschaoticmod.procedures;

import net.planetsaturn.saturnschaoticmod.network.SaturnsChaoticModModVariables;

import net.minecraft.world.entity.Entity;

public class PanicDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean paniccheck = false;
		if ((entity.getCapability(SaturnsChaoticModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaturnsChaoticModModVariables.PlayerVariables())).panic == 1) {
			paniccheck = true;
		} else {
			paniccheck = false;
		}
		return paniccheck;
	}
}
