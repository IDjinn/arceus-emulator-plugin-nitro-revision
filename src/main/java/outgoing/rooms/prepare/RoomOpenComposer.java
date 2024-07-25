package outgoing.rooms.prepare;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.rooms.prepare.IRoomOpenComposer;


public class RoomOpenComposer implements IOutgoingDTOSerializer<IPacketDTO>, IRoomOpenComposer {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomOpenComposer;
    }
}
