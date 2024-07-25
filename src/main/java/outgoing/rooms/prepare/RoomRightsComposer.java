package outgoing.rooms.prepare;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.data.RoomRightsComposerDTO;
import packets.outgoing.rooms.prepare.IRoomRightsComposer;


public class RoomRightsComposer implements IOutgoingDTOSerializer<RoomRightsComposerDTO>, IRoomRightsComposer {
    @Override
    public void compose(IPacketWriter writer, RoomRightsComposerDTO dto) {
        writer.appendInt(dto.rightLevel().ordinal());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomRightsComposer;
    }
}
