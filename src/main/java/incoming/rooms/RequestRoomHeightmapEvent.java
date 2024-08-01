package incoming.rooms;

import com.google.inject.Singleton;
import networking.client.IClient;
import networking.packets.incoming.IIncomingPacket;
import incoming.IncomingEvent;
import incoming.IncomingHeaders;

@Singleton
public class RequestRoomHeightmapEvent extends IncomingEvent {

    @Override
    public int getHeaderId() {
        return IncomingHeaders.RequestHeightmapEvent;
    }

    @Override
    public void parse(IIncomingPacket packet, IClient client) {
        if (client.getHabbo().getPlayerEntity() == null) return;

        client.getHabbo().getPlayerEntity().getRoom().join(client.getHabbo());
    }
}
