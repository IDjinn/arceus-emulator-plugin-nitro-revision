package outgoing.inventory;

import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.inventory.RemoveHabboItemComposerDTO;


public class RemoveHabboItemComposer implements IOutgoingPacket<RemoveHabboItemComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, RemoveHabboItemComposerDTO dto) {
        writer.appendInt(dto.itemId());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RemoveHabboItemComposer;
    }
}
