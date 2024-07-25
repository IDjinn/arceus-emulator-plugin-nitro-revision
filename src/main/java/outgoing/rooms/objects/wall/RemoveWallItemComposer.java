package outgoing.rooms.objects.wall;

import habbo.rooms.components.objects.items.wall.IWallItem;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.wall.RemoveWallItemComposerDTO;


public class RemoveWallItemComposer implements IOutgoingPacket<RemoveWallItemComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, RemoveWallItemComposerDTO dto) {
        writer.appendString(String.valueOf(dto.wallItem().getVirtualId()));
        writer.appendInt(dto.pickupPlayerId());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RemoveWallItemComposer;
    }
}
