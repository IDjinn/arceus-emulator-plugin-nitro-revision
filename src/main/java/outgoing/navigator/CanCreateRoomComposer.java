package outgoing.navigator;

import networking.packets.IOutgoingPacket;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;


public class CanCreateRoomComposer implements IOutgoingPacket<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendInt(0); // 0 = can create room, 1 = room limit reached
        writer.appendInt(50); // room limit
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.CanCreateRoomComposer;
    }
}
