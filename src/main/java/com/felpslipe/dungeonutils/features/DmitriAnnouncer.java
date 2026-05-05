package com.felpslipe.dungeonutils.features;

import com.felpslipe.dungeonutils.events.ChatMsgEvent;
import com.felpslipe.dungeonutils.misc.Utils;
import meteordevelopment.orbit.EventHandler;

import static com.felpslipe.dungeonutils.DungeonUtils.client;

public class DmitriAnnouncer {
    public static String golden = "[BOSS] The Watcher: These will be adorned in the finest gold!";

    @EventHandler
    private static void onMsg(ChatMsgEvent event) {
        if (Utils.isInDungeons() && event.messagePlain.equals(golden)) {
            assert client.player != null;
            client.player.connection.sendChat("pc Blood is Dmitri!");
        }
    }
}
