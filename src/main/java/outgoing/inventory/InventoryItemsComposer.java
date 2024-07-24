package outgoing.inventory;

import habbo.habbos.inventory.IHabboInventoryItem;
import networking.packets.IPacketWriter;
import networking.packets.OutgoingPacket;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.inventory.InventoryItemsComposerDTO;

import java.util.List;

public class InventoryItemsComposer implements OutgoingPacket<InventoryItemsComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, InventoryItemsComposerDTO dto) {
        writer.appendInt(dto.fragment());
        writer.appendInt(dto.totalFragments() - 1);
        writer.appendInt(dto.items().size());
        for (var item : dto.items()) {
            item.serialize(this);
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.InventoryItemsComposer;
    }
}
