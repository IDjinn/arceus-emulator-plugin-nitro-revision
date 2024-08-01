package incoming.rooms.entities.chat;

import com.google.inject.Singleton;
import networking.client.IClient;
import networking.packets.incoming.IIncomingPacket;
import incoming.IncomingEvent;
import incoming.IncomingHeaders;

@Singleton
public class RoomUserStartTypingEvent extends IncomingEvent {
    @Override
    public int getHeaderId() {
        return IncomingHeaders.RoomUserStartTypingEvent;
    }

    @Override
    public void parse(final IIncomingPacket packet, final IClient client) {
        if (client.getHabbo().getRoom() == null || client.getHabbo().getPlayerEntity() == null) return;

        if (!client.getHabbo().getRoom().getRightsManager().canType(client.getHabbo().getPlayerEntity()))
            return;

        client.getHabbo().getRoom().broadcastMessage(
                new RoomUserTypingComposerDTO(client.getHabbo().getPlayerEntity(),
                        true
                ));
    }
}
