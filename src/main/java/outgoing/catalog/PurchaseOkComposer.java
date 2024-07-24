package outgoing.catalog;

import networking.packets.IPacketWriter;
import networking.packets.IOutgoingPacket;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.catalog.PurchaseOkComposerDTO;


public class PurchaseOkComposer implements IOutgoingPacket<PurchaseOkComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, PurchaseOkComposerDTO dto) {
        final var item = dto.catalogItem();
        writer.appendInt(item.getId());
        writer.appendString(item.getFurniture().getItemName());
        writer.appendBoolean(false);// rent
        writer.appendInt(item.getCostCredits());
        writer.appendInt(item.getCostActivityPoints());
        writer.appendInt(0); // points type
        writer.appendBoolean(false); // is gifted

        writer.appendInt(1); // total items
        {
            writer.appendString(item.getFurniture().getType().toString());
            writer.appendInt(item.getFurniture().getSpriteId());
            writer.appendString(""); // extradata
            writer.appendInt(1); // count
            writer.appendString("");
            writer.appendInt(1); // is limited?
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.PurchaseOKComposer;
    }
}
