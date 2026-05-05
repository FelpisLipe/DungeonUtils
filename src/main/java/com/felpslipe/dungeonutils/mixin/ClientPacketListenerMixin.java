package com.felpslipe.dungeonutils.mixin;

import com.felpslipe.dungeonutils.events.ChatMsgEvent;
import com.felpslipe.dungeonutils.misc.Utils;
import net.minecraft.client.multiplayer.ClientPacketListener;
// import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.network.protocol.game.ClientboundSystemChatPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.felpslipe.dungeonutils.DungeonUtils.eventBus;

@Mixin(ClientPacketListener.class)
public class ClientPacketListenerMixin {
    @Inject(method = "handleSystemChat", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/chat/ChatListener;handleSystemMessage(Lnet/minecraft/network/chat/Component;Z)V"), cancellable = true)
    private void handleSystemChat(ClientboundSystemChatPacket clientboundSystemChatPacket, CallbackInfo ci) {
        if(!clientboundSystemChatPacket.overlay()) {
            String msg = Utils.toPlain(clientboundSystemChatPacket.content());
            ChatMsgEvent event = eventBus.post(new ChatMsgEvent(clientboundSystemChatPacket.content(), msg));
            if(event.isCancelled()) {
                ci.cancel();
            }
        }
    }
}
