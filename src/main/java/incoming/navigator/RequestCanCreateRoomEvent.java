package incoming.navigator;

import networking.client.IClient;
import networking.packets.incoming.IIncomingPacket;
import incoming.IncomingEvent;
import incoming.IncomingHeaders;
import packets.dto.outgoing.navigator.CanCreateRoomComposerDTO;

public class RequestCanCreateRoomEvent extends IncomingEvent {
    @Override
    public int getHeaderId() {
        return IncomingHeaders.RequestCanCreateRoomEvent;
    }

    @Override
    public void parse(IIncomingPacket packet, IClient client) {
        client.sendMessage(new CanCreateRoomComposerDTO());
    }
}
