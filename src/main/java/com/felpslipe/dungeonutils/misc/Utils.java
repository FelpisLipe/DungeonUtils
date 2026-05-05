package com.felpslipe.dungeonutils.misc;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public class Utils {
    public static String toPlain(Component text) {
        if (text != null) {
            return ChatFormatting.stripFormatting(text.getString());
        }
        return "";
    }

    public static boolean isInArea(String area) {
        return SbData.getArea().equals(area);
    }

    public static boolean isInDungeons() {
        return isInArea("Catacombs");
    }
}
