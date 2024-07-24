package outgoing.catalog.pages;

import habbo.catalog.pages.ICatalogPage;
import networking.packets.IPacketSerializer;
import networking.packets.IPacketWriter;
import packets.dto.outgoing.catalog.CatalogPageComposerDTO;

public class CatalogPageSerializer implements IPacketSerializer<ICatalogPage> { // TODO: THIS DOES NOT SUPPORT INHERITANCE 

    @Override
    public void serialize(IPacketWriter writer, ICatalogPage dto) {
        writer.appendString("default_3x3");

        writer.appendInt(dto.getImages().size());
        for (var image : dto.getImages())
            writer.appendString(image);

        writer.appendInt(dto.getTexts().size());
        for (var text : dto.getTexts())
            writer.appendString(text);
    }
    public void serializeExtra(IPacketWriter writer, ICatalogPage dto) {
    }
}
