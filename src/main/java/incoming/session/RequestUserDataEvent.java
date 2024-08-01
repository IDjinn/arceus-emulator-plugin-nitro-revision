package incoming.session;

import com.google.inject.Singleton;
import networking.client.IClient;
import networking.packets.incoming.IIncomingPacket;
import incoming.IncomingEvent;
import incoming.IncomingHeaders;
import packets.dto.outgoing.session.logindata.MeMenuSettingsComposerDTO;
import packets.dto.outgoing.session.logindata.UserDataComposerDTO;
import packets.dto.outgoing.session.logindata.UserPerksComposerDTO;

@Singleton
public class RequestUserDataEvent extends IncomingEvent {
    @Override
    public int getHeaderId() {
        return IncomingHeaders.RequestUserDataEvent;
    }

    @Override
    public void parse(IIncomingPacket packet, IClient client) {
        client.sendMessages(
                new UserDataComposerDTO(client.getHabbo()),
                new UserPerksComposerDTO(),
                new MeMenuSettingsComposerDTO()
        );
    }
}
