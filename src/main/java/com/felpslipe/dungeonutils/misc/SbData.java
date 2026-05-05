package com.felpslipe.dungeonutils.misc;

import net.minecraft.ChatFormatting;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundSetPlayerTeamPacket;
import net.minecraft.world.scores.*;

import java.util.ArrayList;
import java.util.List;

import static com.felpslipe.dungeonutils.DungeonUtils.client;

public class SbData {
    private static String location = "";
    private static String area = "";
    private static List<String> lines = new ArrayList<>();

    public static String getArea() {
        return area;
    }

    public static void updateTablist(ClientboundPlayerInfoUpdatePacket packet, List<ClientboundPlayerInfoUpdatePacket.Entry> entries) {
        for(ClientboundPlayerInfoUpdatePacket.Entry entry : entries) {
            if (entry.displayName() == null) continue;
            String name = Utils.toPlain(entry.displayName()).trim();
            if(name.startsWith("Area:") || name.startsWith("Dungeon:")) {
                area = name.split(":", 2)[1].trim();
                break;
            }
        }
    }
    public static void updateScoreboard(ClientboundSetPlayerTeamPacket packet) {
        if(client.player != null) {
            List<String> currentLines = new ArrayList<>();
            Scoreboard scoreboard = client.player.connection.scoreboard();
            Objective objective = scoreboard.getDisplayObjective(DisplaySlot.BY_ID.apply(1));
            for(ScoreHolder scoreHolder : scoreboard.getTrackedPlayers()) {
                if(scoreboard.listPlayerScores(scoreHolder).containsKey(objective)) {
                    PlayerTeam team = scoreboard.getPlayersTeam(scoreHolder.getScoreboardName());
                    if (team != null) {
                        String line = ChatFormatting.stripFormatting(team.getPlayerPrefix().getString() + team.getPlayerSuffix().getString()).trim();
                        if(!line.isEmpty() && (line.startsWith("⏣") || line.startsWith("ф"))) {
                            location = line;
                        }
                        currentLines.add(line);
                    }

                }
            }
            lines = currentLines;
        }


    }
}
