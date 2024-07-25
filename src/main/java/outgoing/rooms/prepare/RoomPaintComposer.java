package outgoing.rooms.prepare;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.data.RoomPaintComposerDTO;
import packets.outgoing.rooms.prepare.IRoomPaintComposer;


public class RoomPaintComposer implements  IRoomPaintComposer {
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
