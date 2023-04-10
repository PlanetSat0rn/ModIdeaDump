package net.planetsaturn.saturnschaoticmod.procedures;

import org.checkerframework.checker.units.qual.s;

import net.planetsaturn.saturnschaoticmod.network.SaturnsChaoticModModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class SetTimeUIProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:TimeInput") ? ((EditBox) guistate.get("text:TimeInput")).getValue() : "");
			entity.getCapability(SaturnsChaoticModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.timer = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
