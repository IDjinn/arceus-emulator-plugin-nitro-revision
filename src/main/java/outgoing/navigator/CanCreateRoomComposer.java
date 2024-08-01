package outgoing.navigator;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.navigator.CanCreateRoomComposerDTO;
import packets.outgoing.navigator.ICanCreateRoomComposer;


public class CanCreateRoomComposer implements  ICanCreateRoomComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.CanCreateRoomComposer;
    }

    @Override
    public void encode(IPacketWriter writer, CanCreateRoomComposerDTO dto) {
        writer.appendInt(0); // 0 = can create room, 1 = room limit reached
        writer.appendInt(50); // room limit
    }
}
