package outgoing.inventory;

import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.inventory.AddHabboItemComposerDTO;
import packets.outgoing.inventory.IAddHabboItemComposer;

public class AddHabboItemComposer implements IAddHabboItemComposer {
    @Override
    public void encode(IPacketWriter writer, AddHabboItemComposerDTO dto) {
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
