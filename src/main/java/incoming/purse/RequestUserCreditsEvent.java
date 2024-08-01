package incoming.purse;

import com.google.inject.Singleton;
import networking.client.IClient;
import networking.packets.incoming.IIncomingPacket;
import incoming.IncomingEvent;
import incoming.IncomingHeaders;
import packets.dto.outgoing.purse.UserCreditsComposerDTO;
import packets.dto.outgoing.purse.UserCurrencyComposerDTO;

import java.util.Collections;

@Singleton
public class RequestUserCreditsEvent extends IncomingEvent {
    @Override
    public int getHeaderId() {
        return IncomingHeaders.RequestUserCreditsEvent;
    }

    @Override
    public void parse(IIncomingPacket packet, IClient client) {
        client.sendMessages(
                new UserCreditsComposerDTO(client.getHabbo().getData().getCredits()),
                new UserCurrencyComposerDTO(Collections.emptySet())
        );
    }
}
