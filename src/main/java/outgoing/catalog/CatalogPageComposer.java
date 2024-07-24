package outgoing.catalog;

import networking.packets.IPacketWriter;
import networking.packets.OutgoingPacket;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.catalog.CatalogPageComposerDTO;


public class CatalogPageComposer implements OutgoingPacket<CatalogPageComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, CatalogPageComposerDTO dto) {
        final var page = dto.page();
        
        writer.appendInt(page.getId());
        writer.appendString(dto.mode());

        page.serialize(this);
        page.serializeItems(this, habbo);
        writer.appendInt(offerId);
        writer.appendBoolean(false, "acceptSeasonCurrencyAsCredits");
        page.serializeExtra(this);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.CatalogPageComposer;
    }
}