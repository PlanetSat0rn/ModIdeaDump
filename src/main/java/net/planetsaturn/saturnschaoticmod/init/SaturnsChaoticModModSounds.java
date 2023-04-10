
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.planetsaturn.saturnschaoticmod.init;

import net.planetsaturn.saturnschaoticmod.SaturnsChaoticModMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public class SaturnsChaoticModModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SaturnsChaoticModMod.MODID);
	public static final RegistryObject<SoundEvent> BLAST = REGISTRY.register("blast", () -> new SoundEvent(new ResourceLocation("saturns_chaotic_mod", "blast")));
	public static final RegistryObject<SoundEvent> TERMINAL_BREAK = REGISTRY.register("terminal_break", () -> new SoundEvent(new ResourceLocation("saturns_chaotic_mod", "terminal_break")));
	public static final RegistryObject<SoundEvent> WARMUSIC = REGISTRY.register("warmusic", () -> new SoundEvent(new ResourceLocation("saturns_chaotic_mod", "warmusic")));
	public static final RegistryObject<SoundEvent> WARMUSICALT = REGISTRY.register("warmusicalt", () -> new SoundEvent(new ResourceLocation("saturns_chaotic_mod", "warmusicalt")));
}
