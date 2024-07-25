package outgoing.session.rooms;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;


public class UserHomeRoomComposer implements IOutgoingDTOSerializer<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
       writer.appendInt(0,"homeRoom");
       writer.appendInt(0,"roomToEnter");
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserHomeRoomComposer;
    }
}