
package net.planetsaturn.saturnschaoticmod.network;

import net.planetsaturn.saturnschaoticmod.world.inventory.TimeControllerUIMenu;
import net.planetsaturn.saturnschaoticmod.procedures.TimeIncreaseUIProcedure;
import net.planetsaturn.saturnschaoticmod.procedures.TimeDecreaseUIProcedure;
import net.planetsaturn.saturnschaoticmod.procedures.SetTimeUIProcedure;
import net.planetsaturn.saturnschaoticmod.procedures.ExplodeMeProcedure;
import net.planetsaturn.saturnschaoticmod.SaturnsChaoticModMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TimeControllerUIButtonMessage {
	private final int buttonID, x, y, z;

	public TimeControllerUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public TimeControllerUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(TimeControllerUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(TimeControllerUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = TimeControllerUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			TimeDecreaseUIProcedure.execute(entity);
		}
		if (buttonID == 1) {

			TimeIncreaseUIProcedure.execute(entity);
		}
		if (buttonID == 2) {

			ExplodeMeProcedure.execute(entity);
		}
		if (buttonID == 3) {

			SetTimeUIProcedure.execute(entity, guistate);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SaturnsChaoticModMod.addNetworkMessage(TimeControllerUIButtonMessage.class, TimeControllerUIButtonMessage::buffer, TimeControllerUIButtonMessage::new, TimeControllerUIButtonMessage::handler);
	}
}
