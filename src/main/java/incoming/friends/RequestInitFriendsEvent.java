package incoming.friends;

import com.google.inject.Singleton;
import networking.client.IClient;
import networking.packets.incoming.IIncomingPacket;
import incoming.IncomingEvent;
import incoming.IncomingHeaders;
import packets.dto.outgoing.messenger.MessengerInitComposerDTO;

@Singleton
public class RequestInitFriendsEvent extends IncomingEvent {
    @Override
    public int getHeaderId() {
        return IncomingHeaders.RequestInitFriendsEvent;
    }

    @Override
    public void parse(IIncomingPacket packet, IClient client) {
        // TODO
        client.sendMessage(new MessengerInitComposerDTO());
    }
}
