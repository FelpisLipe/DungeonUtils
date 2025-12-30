package com.felpslipe.dungeonutils.mixin;

import com.felpslipe.dungeonutils.misc.SbData;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.PlayerListS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ClientConnection.class)
public abstract class ClientConnectionMixin {
    @Inject(method = "handlePacket", at = @At(value= "HEAD"))
    private static void onReceive(Packet<?> packet, PacketListener listener, CallbackInfo ci) {
        if(packet instanceof PlayerListS2CPacket listPacket) {
            SbData.updateTablist(listPacket, listPacket.getEntries());
        }
    }
}
