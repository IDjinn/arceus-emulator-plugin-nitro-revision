package outgoing.session.hotel;

import networking.packets.IOutgoingPacket;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;

public class AvailabilityStatusMessageComposer implements IOutgoingPacket<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendBoolean(true);
        writer.appendBoolean(false);
        writer.appendBoolean(true);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.AvailabilityStatusMessageComposer;
    }
}
