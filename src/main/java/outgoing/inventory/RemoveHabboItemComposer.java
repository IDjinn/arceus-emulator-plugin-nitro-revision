package outgoing.inventory;

import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.inventory.RemoveHabboItemComposerDTO;
import packets.outgoing.inventory.IRemoveHabboItemComposer;


public class RemoveHabboItemComposer implements  IRemoveHabboItemComposer {
    @Override
    public void encode(IPacketWriter writer, RemoveHabboItemComposerDTO dto) {
        writer.appendInt(dto.itemId());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RemoveHabboItemComposer;
    }
}
