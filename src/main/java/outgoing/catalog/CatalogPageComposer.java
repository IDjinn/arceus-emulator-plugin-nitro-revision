package outgoing.catalog;

import com.google.inject.Inject;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import outgoing.catalog.pages.CatalogPageItemsSerializer;
import outgoing.catalog.pages.CatalogPageSerializer;
import packets.dto.outgoing.catalog.CatalogPageComposerDTO;


public class CatalogPageComposer implements IOutgoingPacket<CatalogPageComposerDTO> {
    private @Inject CatalogPageSerializer catalogPageSerializer;
    private @Inject CatalogPageItemsSerializer catalogPageItemsSerializer;
    @Override
    public void compose(IPacketWriter writer, CatalogPageComposerDTO dto) {
        final var page = dto.page();
        
        writer.appendInt(page.getId());
        writer.appendString(dto.mode());

        this.catalogPageSerializer.serialize(writer, page);
        this.catalogPageItemsSerializer.serialize(writer, dto);
        writer.appendInt(dto.offerId());
        writer.appendBoolean(false, "acceptSeasonCurrencyAsCredits");
        this.catalogPageSerializer.serializeExtra(writer, page);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.CatalogPageComposer;
    }
}