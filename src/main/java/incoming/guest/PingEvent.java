package incoming.guest;

import com.google.inject.Singleton;
import networking.client.IClient;
import networking.packets.incoming.IIncomingPacket;
import incoming.IncomingEvent;
import networking.util.NoAuth;
import incoming.IncomingHeaders;
import packets.dto.outgoing.session.PingComposerDTO;

@Singleton
@NoAuth
public class PingEvent extends IncomingEvent {
    @Override
    public int getHeaderId() {
        return IncomingHeaders.PongEvent;
    }

    @Override
    public void parse(IIncomingPacket packet, IClient client) {
        client.sendMessage(new PingComposerDTO());
    }
}
