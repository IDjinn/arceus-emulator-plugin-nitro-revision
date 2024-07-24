package outgoing.session.hotel;

import networking.packets.OutgoingPacket;
import networking.packets.PacketDTO;
import networking.packets.PacketWriter;
import outgoing.OutgoingHeaders;

public class AvailabilityStatusMessageComposer implements OutgoingPacket<PacketDTO> {
    @Override
    public void compose(PacketWriter writer, PacketDTO dto) {
        writer.appendBoolean(true);
        writer.appendBoolean(false);
        writer.appendBoolean(true);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.AvailabilityStatusMessageComposer);
    }
}
