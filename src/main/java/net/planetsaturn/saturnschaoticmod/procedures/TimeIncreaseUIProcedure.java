package net.planetsaturn.saturnschaoticmod.procedures;

import net.planetsaturn.saturnschaoticmod.network.SaturnsChaoticModModVariables;

import net.minecraft.world.entity.Entity;

public class TimeIncreaseUIProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(SaturnsChaoticModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaturnsChaoticModModVariables.PlayerVariables())).timer + 10;
			entity.getCapability(SaturnsChaoticModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.timer = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
