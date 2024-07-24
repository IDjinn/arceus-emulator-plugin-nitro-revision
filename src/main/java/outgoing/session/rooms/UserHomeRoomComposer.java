package outgoing.session.rooms;

import networking.packets.OutgoingPacket;
import networking.packets.PacketDTO;
import networking.packets.PacketWriter;
import outgoing.OutgoingHeaders;


public class UserHomeRoomComposer implements OutgoingPacket<PacketDTO> {
    @Override
    public void compose(PacketWriter writer, PacketDTO dto) {
       writer.appendInt(0,"homeRoom");
       writer.appendInt(0,"roomToEnter");
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserHomeRoomComposer;
    }
}