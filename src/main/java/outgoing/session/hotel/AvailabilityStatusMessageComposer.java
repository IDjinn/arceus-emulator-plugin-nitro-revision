package outgoing.session.hotel;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.hotel.AvailabilityStatusMessageComposerDTO;
import packets.outgoing.session.hotel.IAvailabilityStatusMessageComposer;

public class AvailabilityStatusMessageComposer implements  IAvailabilityStatusMessageComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.AvailabilityStatusMessageComposer;
    }

    @Override
    public void encode(IPacketWriter writer, AvailabilityStatusMessageComposerDTO dto) {
        writer.appendBoolean(true);
        writer.appendBoolean(false);
        writer.appendBoolean(true);
    }
}
