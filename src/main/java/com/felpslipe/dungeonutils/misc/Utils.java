package com.felpslipe.dungeonutils.misc;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class Utils {
    public static String toPlain(Text text) {
        if (text != null) {
            return Formatting.strip(text.getString());
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
