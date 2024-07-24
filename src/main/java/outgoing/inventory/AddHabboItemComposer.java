package outgoing.inventory;

import networking.packets.IPacketWriter;
import networking.packets.OutgoingPacket;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.inventory.AddHabboItemCategory;
import packets.dto.outgoing.inventory.AddHabboItemComposerDTO;

import java.util.List;

public class AddHabboItemComposer implements OutgoingPacket<AddHabboItemComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, AddHabboItemComposerDTO dto) {
        writer.appendInt(1, "total unseen categories");
        writer.appendInt(dto.category().ordinal());
        writer.appendInt(dto.itemIds().size());
        for (int itemId : dto.itemIds()) {
            writer.appendInt(itemId);
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.AddHabboItemComposer;
    }
}
