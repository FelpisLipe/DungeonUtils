package com.felpslipe.dungeonutils.mixin;

import com.felpslipe.dungeonutils.events.ChatMsgEvent;
import com.felpslipe.dungeonutils.misc.Utils;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.felpslipe.dungeonutils.DungeonUtils.eventBus;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
    @Inject(method = "onGameMessage", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/message/MessageHandler;onGameMessage(Lnet/minecraft/text/Text;Z)V"), cancellable = true)
    private void onGameMessage(GameMessageS2CPacket packet, CallbackInfo ci) {
        if(!packet.overlay()) {
            String msg = Utils.toPlain(packet.content());
            ChatMsgEvent event = eventBus.post(new ChatMsgEvent(packet.content(), msg));
            if(event.isCancelled()) {
                ci.cancel();
            }
        }
    }
}
