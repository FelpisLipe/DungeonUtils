package com.felpslipe.dungeonutils.misc;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.joml.Quaternionf;

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
    public static Quaternionf getDegreesQuat(double x, double y, double z, float angle) {
        float radAngle = (float) Math.toRadians(angle);
        double f = Math.sin(radAngle / 2f);
        return new Quaternionf(x * f, y * f, z *f, Math.cos(radAngle/2f));
    }
}
