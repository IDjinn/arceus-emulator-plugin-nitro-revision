package outgoing.inventory;

import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.inventory.InventoryItemsComposerDTO;
import packets.outgoing.inventory.IInventoryItemsComposer;

public class InventoryItemsComposer implements  IInventoryItemsComposer {
    @Override
    public void encode(IPacketWriter writer, InventoryItemsComposerDTO dto) {
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
