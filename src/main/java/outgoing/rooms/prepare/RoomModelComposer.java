package outgoing.rooms.prepare;

import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.data.RoomModelComposerDTO;
import packets.outgoing.rooms.data.IRoomModelComposer;


public class RoomModelComposer implements  IRoomModelComposer {
    @Override
    public void compose(IPacketWriter writer, RoomModelComposerDTO dto) {
        writer.appendString(dto.modelName());
        writer.appendInt(dto.roomId());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomModelComposer;
    }
}
