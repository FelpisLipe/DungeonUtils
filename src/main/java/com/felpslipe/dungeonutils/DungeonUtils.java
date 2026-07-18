package com.felpslipe.dungeonutils;

import com.felpslipe.dungeonutils.features.DmitriAnnouncer;
import com.felpslipe.dungeonutils.features.GKey;
import meteordevelopment.orbit.EventBus;
import meteordevelopment.orbit.IEventBus;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class DungeonUtils implements ClientModInitializer {
	public static final String MOD_ID = "dungeon-utils";

    public static Minecraft client;
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final IEventBus eventBus = new EventBus();

	@Override
	public void onInitializeClient() {
        client = Minecraft.getInstance();
        eventBus.registerLambdaFactory("com.felpslipe.dungeonutils", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));
        eventBus.subscribe(DmitriAnnouncer.class);
        GKey.register();
        LOGGER.info("[DungeonUtils] Ass");
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (GKey.GKEY.consumeClick()) {
                if (client.player != null) {
                    client.keyboardHandler.setClipboard(GKey.secret);
                    client.player.displayClientMessage(Component.literal("Gave 1 [Ghost Block] to ").append(client.player.getName()), false);
                }
            }
        });
	}
}