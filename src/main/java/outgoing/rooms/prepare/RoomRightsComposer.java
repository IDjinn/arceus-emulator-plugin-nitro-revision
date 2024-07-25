package outgoing.rooms.prepare;

import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.data.RoomRightsComposerDTO;


public class RoomRightsComposer implements IOutgoingPacket<RoomRightsComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, RoomRightsComposerDTO dto) {
        writer.appendInt(dto.rightLevel().ordinal());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomRightsComposer;
    }
}
