package incoming.catalog;

import com.google.inject.Inject;
import habbo.catalog.ICatalogManager;
import networking.client.IClient;
import networking.packets.incoming.IIncomingPacket;
import incoming.IncomingEvent;
import incoming.IncomingHeaders;
import packets.dto.outgoing.catalog.CatalogPageComposerDTO;

public class RequestCatalogPage extends IncomingEvent {
    @Inject
    ICatalogManager catalogManager;

    @Override
    public int getHeaderId() {
        return IncomingHeaders.RequestCatalogPageEvent;
    }

    @Override
    public void parse(IIncomingPacket packet, IClient client) {
        var pageId = packet.readInt();
        var offerId = packet.readInt();
        var mode = packet.readString();

        var page = this.catalogManager.getCatalogPageForHabbo(pageId, client.getHabbo());
        if (page == null)
            return;

        client.sendMessage(new CatalogPageComposerDTO(page, client.getHabbo(), offerId, mode));
    }
}
