package com.felpslipe.dungeonutils.misc;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

public class SwordBlockHelper {
    public static void swordBlockFirstPerson(MatrixStack matrix) {
        matrix.translate(-0.15f, 0.16f, 0.15f);
        matrix.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-18.0f));
        matrix.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(82.0f));
        matrix.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(112.0f));
    }

    public static void swordBlockThirdPerson(MatrixStack matrix) {
        matrix.translate(-0.22f, 0.07f, 0.10f);
        matrix.multiply(RotationAxis.POSITIVE_X.rotationDegrees(25.0f));
        matrix.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(30.0f));
        matrix.multiply(RotationAxis.POSITIVE_X.rotationDegrees(0.0f));
        matrix.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(70.0f));
    }

}
