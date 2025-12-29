package com.felpslipe;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DungeonUtils implements ClientModInitializer {
	public static final String MOD_ID = "dungeon-utils";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            String rawText = message.getString(); // Strips formatting

            if (client.player != null && (rawText.contains("[BOSS] The Watcher: These will be adorned in the finest gold! "))) {
                client.inGameHud.setTitle(Text.of("DMITRI"));
                client.player.networkHandler.sendChatCommand("pc Blood is Dmitri!");
            }
        });
	}
}