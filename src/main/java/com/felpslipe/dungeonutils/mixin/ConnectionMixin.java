package com.felpslipe.dungeonutils.mixin;

import com.felpslipe.dungeonutils.misc.SbData;
import net.minecraft.network.Connection;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Connection.class)
public abstract class ConnectionMixin {
    @Inject(method = "genericsFtw", at = @At(value= "HEAD"))
    private static <T extends PacketListener>  void onReceive(Packet<T> packet, PacketListener packetListener, CallbackInfo ci) {
        if(packet instanceof ClientboundPlayerInfoUpdatePacket listPacket) {
            SbData.updateTablist(listPacket, listPacket.entries());
        }
    }
}
