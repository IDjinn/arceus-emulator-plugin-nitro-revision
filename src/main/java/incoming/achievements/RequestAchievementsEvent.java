package incoming.achievements;

import com.google.inject.Singleton;
import incoming.IncomingHeaders;
import networking.client.IClient;
import networking.packets.incoming.IIncomingPacket;
import incoming.IncomingEvent;
import packets.dto.outgoing.achievemetns.AchievementListComposerDTO;

@Singleton
public class RequestAchievementsEvent extends IncomingEvent {
    @Override
    public int getHeaderId() {
        return IncomingHeaders.RequestAchievementsEvent;
    }

    @Override
    public void parse(IIncomingPacket packet, IClient client) {
        client.sendMessage(new AchievementListComposerDTO()); // TODO
    }
}
