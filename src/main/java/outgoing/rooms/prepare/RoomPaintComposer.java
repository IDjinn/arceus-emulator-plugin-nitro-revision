package outgoing.rooms.prepare;

import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.data.RoomPaintComposerDTO;


public class RoomPaintComposer implements IOutgoingPacket<RoomPaintComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, RoomPaintComposerDTO dto) {
        writer.appendString(dto.type());
        writer.appendString(dto.value());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomPaintComposer;
    }
}
