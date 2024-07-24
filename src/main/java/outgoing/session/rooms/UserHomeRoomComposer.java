package outgoing.session.rooms;

import networking.packets.IPacketWriter;
import networking.packets.OutgoingPacket;
import networking.packets.IPacketDTO;
import outgoing.OutgoingHeaders;


public class UserHomeRoomComposer implements OutgoingPacket<IPacketDTO> {
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