package incoming.inventory;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import habbo.habbos.IHabboManager;
import networking.client.IClient;
import networking.packets.incoming.IIncomingPacket;
import incoming.IncomingEvent;
import incoming.IncomingHeaders;
import packets.dto.outgoing.badges.UserBadgesComposerDTO;
import packets.dto.outgoing.inventory.InventoryBadgesComposerDTO;
import storage.repositories.habbo.IHabboBadgesRepository;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class RequestInventoryBadgesEvent extends IncomingEvent {
    @Inject
    IHabboManager habboManager;
    @Inject
    IHabboBadgesRepository badgesRepository;

    @Override
    public int getHeaderId() {
        return IncomingHeaders.RequestInventoryBadgesEvent;
    }

    @Override
    public void parse(IIncomingPacket packet, IClient client) {
        if (packet.getReadableBytes() == 0) {
            client.sendMessages(new InventoryBadgesComposerDTO(
                    client.getHabbo().getBadgesComponent().getBadges(),
                    client.getHabbo().getBadgesComponent().getProfileEquippedBadges()
            ));
            return;
        }

        final int userId = packet.readInt();
        if (this.habboManager.isOnline(userId)) {
            final var target = this.habboManager.getOnlineHabbo(userId).get();
            client.sendMessage(UserBadgesComposerDTO.of(userId, target.getBadgesComponent().getProfileEquippedBadges()));
            return;
        }

        // TODO IMPLEMENTATION ELSEWHERE TO CACHING ETC
        final Map<Integer, String> equippedBadges = new HashMap<>();
        this.badgesRepository.getEquippedBadges(result -> {
            if (result == null) return;

            equippedBadges.put(result.getInt("slot_id"), result.getString("badge_code"));
        }, userId);
        
        client.sendMessage(new UserBadgesComposerDTO(userId, equippedBadges));
    }
}
