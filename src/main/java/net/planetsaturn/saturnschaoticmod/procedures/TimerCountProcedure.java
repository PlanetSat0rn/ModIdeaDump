package net.planetsaturn.saturnschaoticmod.procedures;

import net.planetsaturn.saturnschaoticmod.network.SaturnsChaoticModModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TimerCountProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(SaturnsChaoticModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaturnsChaoticModModVariables.PlayerVariables())).WARTickCounter + 1;
			entity.getCapability(SaturnsChaoticModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.WARTickCounter = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(SaturnsChaoticModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaturnsChaoticModModVariables.PlayerVariables())).WARTickCounter == 20) {
			{
				double _setval = 0;
				entity.getCapability(SaturnsChaoticModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.WARTickCounter = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(SaturnsChaoticModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaturnsChaoticModModVariables.PlayerVariables())).panic == 1) {
				{
					double _setval = (entity.getCapability(SaturnsChaoticModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaturnsChaoticModModVariables.PlayerVariables())).timer - 1;
					entity.getCapability(SaturnsChaoticModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.timer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getCapability(SaturnsChaoticModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaturnsChaoticModModVariables.PlayerVariables())).timer < 0) {
					for (int index0 = 0; index0 < (int) (10); index0++) {
						if (world instanceof Level _level && !_level.isClientSide())
							_level.explode(null, x, y, z, 4, Explosion.BlockInteraction.BREAK);
					}
				}
			}
		}
	}
}
