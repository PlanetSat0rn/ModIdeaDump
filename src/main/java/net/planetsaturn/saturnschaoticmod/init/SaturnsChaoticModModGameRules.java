
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.planetsaturn.saturnschaoticmod.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SaturnsChaoticModModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> CHANGEWARMUSIC = GameRules.register("changeWarMusic", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
}
