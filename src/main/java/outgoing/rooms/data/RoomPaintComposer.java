package outgoing.rooms.data;

import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.data.RoomPaintComposerDTO;
import packets.outgoing.rooms.data.IRoomPaintComposer;


public class RoomPaintComposer implements  IRoomPaintComposer {
    @Override
    public void encode(IPacketWriter writer, RoomPaintComposerDTO dto) {
        writer.appendString(dto.type());
        writer.appendString(dto.value());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomPaintComposer;
    }
}
