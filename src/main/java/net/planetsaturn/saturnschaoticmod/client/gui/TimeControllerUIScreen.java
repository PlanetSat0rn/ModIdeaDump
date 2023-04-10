package net.planetsaturn.saturnschaoticmod.client.gui;

import net.planetsaturn.saturnschaoticmod.world.inventory.TimeControllerUIMenu;
import net.planetsaturn.saturnschaoticmod.network.TimeControllerUIButtonMessage;
import net.planetsaturn.saturnschaoticmod.SaturnsChaoticModMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class TimeControllerUIScreen extends AbstractContainerScreen<TimeControllerUIMenu> {
	private final static HashMap<String, Object> guistate = TimeControllerUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox TimeInput;
	Button button_decrease_time_by_10;
	Button button_increase_time_by_10;
	Button button_just_explode_me_already;
	Button button_set_time_to;

	public TimeControllerUIScreen(TimeControllerUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("saturns_chaotic_mod:textures/screens/time_controller_ui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		TimeInput.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (TimeInput.isFocused())
			return TimeInput.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		TimeInput.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		TimeInput = new EditBox(this.font, this.leftPos + 24, this.topPos + 70, 120, 20, Component.translatable("gui.saturns_chaotic_mod.time_controller_ui.TimeInput")) {
			{
				setSuggestion(Component.translatable("gui.saturns_chaotic_mod.time_controller_ui.TimeInput").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.saturns_chaotic_mod.time_controller_ui.TimeInput").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.saturns_chaotic_mod.time_controller_ui.TimeInput").getString());
				else
					setSuggestion(null);
			}
		};
		TimeInput.setMaxLength(32767);
		guistate.put("text:TimeInput", TimeInput);
		this.addWidget(this.TimeInput);
		button_decrease_time_by_10 = new Button(this.leftPos + 24, this.topPos + 16, 129, 20, Component.translatable("gui.saturns_chaotic_mod.time_controller_ui.button_decrease_time_by_10"), e -> {
			if (true) {
				SaturnsChaoticModMod.PACKET_HANDLER.sendToServer(new TimeControllerUIButtonMessage(0, x, y, z));
				TimeControllerUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_decrease_time_by_10", button_decrease_time_by_10);
		this.addRenderableWidget(button_decrease_time_by_10);
		button_increase_time_by_10 = new Button(this.leftPos + 24, this.topPos + 43, 124, 20, Component.translatable("gui.saturns_chaotic_mod.time_controller_ui.button_increase_time_by_10"), e -> {
			if (true) {
				SaturnsChaoticModMod.PACKET_HANDLER.sendToServer(new TimeControllerUIButtonMessage(1, x, y, z));
				TimeControllerUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_increase_time_by_10", button_increase_time_by_10);
		this.addRenderableWidget(button_increase_time_by_10);
		button_just_explode_me_already = new Button(this.leftPos + 15, this.topPos + 133, 145, 20, Component.translatable("gui.saturns_chaotic_mod.time_controller_ui.button_just_explode_me_already"), e -> {
			if (true) {
				SaturnsChaoticModMod.PACKET_HANDLER.sendToServer(new TimeControllerUIButtonMessage(2, x, y, z));
				TimeControllerUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_just_explode_me_already", button_just_explode_me_already);
		this.addRenderableWidget(button_just_explode_me_already);
		button_set_time_to = new Button(this.leftPos + 24, this.topPos + 97, 82, 20, Component.translatable("gui.saturns_chaotic_mod.time_controller_ui.button_set_time_to"), e -> {
			if (true) {
				SaturnsChaoticModMod.PACKET_HANDLER.sendToServer(new TimeControllerUIButtonMessage(3, x, y, z));
				TimeControllerUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_set_time_to", button_set_time_to);
		this.addRenderableWidget(button_set_time_to);
	}
}
