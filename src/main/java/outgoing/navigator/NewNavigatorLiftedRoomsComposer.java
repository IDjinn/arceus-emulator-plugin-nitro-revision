package outgoing.navigator;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import networking.packets.OutgoingPacket;
import outgoing.OutgoingHeaders;


public class NewNavigatorLiftedRoomsComposer implements OutgoingPacket<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendInt(0);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.NewNavigatorLiftedRoomsComposer;
    }
}
