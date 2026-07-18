package com.felpslipe.dungeonutils.features;

import com.felpslipe.dungeonutils.DungeonUtils;
import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public class GKey {
    public static KeyMapping.Category DU_CATEGORY;
    public static KeyMapping GKEY;

    public static void register() {
        DU_CATEGORY = KeyMapping.Category.register(Identifier.fromNamespaceAndPath(DungeonUtils.MOD_ID, "dutils"));
       GKEY = KeyBindingHelper.registerKeyBinding(new KeyMapping("key.dungeon-utils.gkey", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, DU_CATEGORY));

    }
    public static final String secret = "                       ;:::::;                        \n" +
                                  "                    :::::::::::::.:;                  \n" +
                                  "                    ::::::::::::::::::.               \n" +
                                  "                  .::::::::::::::::::::::             \n" +
                                  "      :       :..................::::::::             \n" +
                                  " ..:....:::::::::::...........:...::::::.....         \n" +
                                  "::.:::::::::.............:::::::::::::::::.:::::;:    \n" +
                                  "::....:.....::::....::...:::::::.........:::::::::::  \n" +
                                  "::....::::::::::::::::::::::::..............:::::::+  \n" +
                                  ":::::.::::::::::::::::::::::::::::...........::::;X+  \n" +
                                  "::::::;;::::::::::......:::::::::::::.......::::$&&+  \n" +
                                  "  ::::;;;+++;:::::...::::::::;;;:::::.....::::::$$x:  \n" +
                                  "  ::::::;+++;:::::...::::;::::;;;::::::::::::::;:::;  \n" +
                                  "  :::::::::;;::::......::;;:::;:::::::::::::;;;;:::;  \n" +
                                  "  .:::..::::;;;:::......:::;X$::::::::::::::;;;;:::.  \n" +
                                  "  ;:::...:::;;;;::::....:::$&$:::;;;;:::::::xX$x::::  \n" +
                                  "  ;;;:::.:;;;;;;::::::::..:Xx;:.:;;;;;;xx:::X$$x:::;  \n" +
                                  "  ;;;:::::;;::;;;;;;;:::...:::..:XxX&&&&x:::X$$x:::;  \n" +
                                  "  ;;;;:::::::..:;;;;;::::..:::;;;&&&&&&&XX&&&&$x::::  \n" +
                                  "  :;;;::::::...:::;;;:::::::::;;;&&&&&&&&&&&&$X+;;;:  \n" +
                                  "  .;;;:::::::::.::;;;;;;:::::::::;&&&&&&&&&&xxx+;;;.  \n" +
                                  "  .;;;;;;;:::::...:::;;;:::::::::;&&&&&&&&&&xxx+;;;.  \n" +
                                  "  .+++;;;;;::::...::::;;:::::::::;xxx$&&&&&$$$$x;;;.  \n" +
                                  "  .+++;;;;;;::::::::::;:::::::;;;;xxx$&&$XXX$&$x;;+.  \n" +
                                  "    ;;;;;;;;;;;::::::::::::::;;;;;X$&&&&$XXX$xx+;;    \n" +
                                  "         :;;;;;;;:::::::;;;;;;;;;;&&&&&&Xxxx++++      \n" +
                                  "             ;:;;::::;;;;;;;;;;;;;&&Xxxxxxxx+++;      \n" +
                                  "                  :::;;;++++++;;;+++++xxxx++          \n" +
                                  "                       :++++++;. .+++++               \n" +
                                  "                          ;;      +                   \n";


}
