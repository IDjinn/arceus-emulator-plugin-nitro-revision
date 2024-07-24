package outgoing.rooms.prepare;

import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.data.RoomModelComposerDTO;


public class RoomModelComposer implements IOutgoingPacket<RoomModelComposerDTO> {
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
