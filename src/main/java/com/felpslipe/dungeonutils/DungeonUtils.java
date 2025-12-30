package com.felpslipe.dungeonutils;

import com.felpslipe.dungeonutils.features.DmitriAnnouncer;
import meteordevelopment.orbit.EventBus;
import meteordevelopment.orbit.IEventBus;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class DungeonUtils implements ModInitializer {
	public static final String MOD_ID = "dungeon-utils";

    public static MinecraftClient client;
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final IEventBus eventBus = new EventBus();
	@Override
	public void onInitialize() {
        client = MinecraftClient.getInstance();
        eventBus.registerLambdaFactory("com.felpslipe.dungeonutils", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));
        eventBus.subscribe(DmitriAnnouncer.class);
        LOGGER.info("[DungeonUtils] Ass");
	}
}