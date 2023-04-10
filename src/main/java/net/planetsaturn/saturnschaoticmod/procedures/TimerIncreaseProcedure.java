package net.planetsaturn.saturnschaoticmod.procedures;

import net.planetsaturn.saturnschaoticmod.network.SaturnsChaoticModModVariables;

import net.minecraft.world.entity.Entity;

public class TimerIncreaseProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		{
			double _setval = (sourceentity.getCapability(SaturnsChaoticModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaturnsChaoticModModVariables.PlayerVariables())).timer + 3;
			sourceentity.getCapability(SaturnsChaoticModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.timer = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
	}
}
