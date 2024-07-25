package outgoing.rooms.data;

import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.data.RoomRightsComposerDTO;
import packets.outgoing.rooms.data.IRoomRightsComposer;


public class RoomRightsComposer implements  IRoomRightsComposer {
    @Override
    public void compose(IPacketWriter writer, RoomRightsComposerDTO dto) {
        writer.appendInt(dto.rightLevel().ordinal());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomRightsComposer;
    }
}
