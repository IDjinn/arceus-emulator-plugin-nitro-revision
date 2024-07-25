package outgoing.rooms.objects.floor;

import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.floor.RemoveFloorItemComposerDTO;


public class RemoveFloorItemComposer implements IOutgoingPacket<RemoveFloorItemComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, RemoveFloorItemComposerDTO dto) {
        writer.appendString(String.valueOf(dto.floorItem().getVirtualId()));
        writer.appendBoolean(false, "isExpired");
        writer.appendInt(dto.pickupPlayerId());
        writer.appendInt(dto.delay());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RemoveFloorItemComposer;
    }
}
