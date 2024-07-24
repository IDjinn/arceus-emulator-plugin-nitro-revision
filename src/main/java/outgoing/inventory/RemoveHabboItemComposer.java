package outgoing.inventory;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import networking.packets.OutgoingPacket;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.inventory.RemoveHabboItemComposerDTO;


public class RemoveHabboItemComposer implements OutgoingPacket<RemoveHabboItemComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, RemoveHabboItemComposerDTO dto) {
        writer.appendInt(dto.itemId());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RemoveHabboItemComposer;
    }
}
