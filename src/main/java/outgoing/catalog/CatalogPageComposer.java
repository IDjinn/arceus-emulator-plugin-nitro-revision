package outgoing.catalog;

import com.google.inject.Inject;
import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.catalog.ICatalogPageComposer;
import serializers.catalog.CatalogPageItemsSerializer;
import serializers.catalog.CatalogPageSerializer;
import packets.dto.outgoing.catalog.CatalogPageComposerDTO;


public class CatalogPageComposer implements  ICatalogPageComposer {
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