package outgoing.catalog;

import habbo.catalog.pages.ICatalogPage;
import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.catalog.CatalogIndexComposerDTO;
import packets.outgoing.catalog.ICatalogIndexComposer;

public class CatalogIndexComposer implements ICatalogIndexComposer {
    @Override
    public void compose(IPacketWriter writer, CatalogIndexComposerDTO dto) {
        writer.appendBoolean(true, "isVisible");
        writer.appendInt(0, "icon");
        writer.appendInt(-1, "page_id");
        writer.appendString("root", "caption");
        writer.appendString("", "localization");
        writer.appendInt(0, "offers");

        writer.appendInt(dto.pages().size());
        for (var page : dto.pages()) {
            serializePage(writer, page, dto.showId());
        }

        writer.appendBoolean(false);
        writer.appendString(dto.mode());
    }

    private void serializePage(final IPacketWriter writer, final ICatalogPage catalogPage, final boolean showId) {
        writer.appendBoolean(catalogPage.isVisible());
        writer.appendInt(catalogPage.getIcon());
        writer.appendInt(catalogPage.isEnabled() ? catalogPage.getId() : -1);
        writer.appendString(catalogPage.getCaption());
        writer.appendString(showId ? STR."\{catalogPage.getCaption()} (\{catalogPage.getId()})" : catalogPage.getCaption());
        writer.appendInt(0, "offer-ids size");

        writer.appendInt(catalogPage.getChildren().size());
        for (var page : catalogPage.getChildren()) {
            this.serializePage(writer, page, showId);
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.CatalogPagesListComposer;
    }
}
