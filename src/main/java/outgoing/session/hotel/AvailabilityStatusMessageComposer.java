package outgoing.session.hotel;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.session.hotel.IAvailabilityStatusMessageComposer;

public class AvailabilityStatusMessageComposer implements  IAvailabilityStatusMessageComposer {
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
