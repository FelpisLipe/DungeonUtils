package com.felpslipe.dungeonutils.misc;

import net.minecraft.network.packet.s2c.play.PlayerListS2CPacket;
import net.minecraft.network.packet.s2c.play.TeamS2CPacket;
import net.minecraft.scoreboard.*;
import net.minecraft.util.Formatting;

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

    public static void updateTablist(PlayerListS2CPacket packet, List<PlayerListS2CPacket.Entry> entries) {
        for(PlayerListS2CPacket.Entry entry : entries) {
            if (entry.displayName() == null) continue;
            String name = Utils.toPlain(entry.displayName()).trim();
            if(name.startsWith("Area:") || name.startsWith("Dungeon:")) {
                area = name.split(":", 2)[1].trim();
                break;
            }
        }
    }
    public static void updateScoreboard(TeamS2CPacket packet) {
        if(client.player != null) {
            List<String> currentLines = new ArrayList<>();
            Scoreboard scoreboard = client.player.networkHandler.getScoreboard();
            ScoreboardObjective objective = scoreboard.getObjectiveForSlot(ScoreboardDisplaySlot.FROM_ID.apply(1));
            for(ScoreHolder scoreHolder : scoreboard.getKnownScoreHolders()) {
                if(scoreboard.getScoreHolderObjectives(scoreHolder).containsKey(objective)) {
                    Team team = scoreboard.getScoreHolderTeam(scoreHolder.getNameForScoreboard());
                    if (team != null) {
                        String line = Formatting.strip(team.getPrefix().getString() + team.getSuffix().getString()).trim();
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
