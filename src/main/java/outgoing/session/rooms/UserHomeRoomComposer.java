package outgoing.session.rooms;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.rooms.UserHomeRoomComposerDTO;
import packets.outgoing.session.rooms.IUserHomeRoomComposer;


public class UserHomeRoomComposer implements IUserHomeRoomComposer {
    @Override
    public void encode(IPacketWriter writer, UserHomeRoomComposerDTO dto) {
       writer.appendInt(0,"homeRoom");
       writer.appendInt(0,"roomToEnter");
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserHomeRoomComposer;
    }
}