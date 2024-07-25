package outgoing.rooms.data;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.rooms.data.IRoomOpenComposer;


public class RoomOpenComposer implements  IRoomOpenComposer {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomOpenComposer;
    }
}
