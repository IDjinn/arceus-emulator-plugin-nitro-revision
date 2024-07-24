package outgoing.session.calendar;

import networking.packets.OutgoingPacket;
import networking.packets.PacketDTO;
import networking.packets.PacketWriter;
import outgoing.OutgoingHeaders;


public class AdventCalendarDataComposer implements OutgoingPacket<PacketDTO> {
    @Override
    public void compose(PacketWriter writer, PacketDTO dto) {
        writer.appendString("xmas14");
        writer.appendString("");
        writer.appendInt(0);
        writer.appendInt(0);
        writer.appendInt(0);
        writer.appendInt(0);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.AdventCalendarDataComposer;
    }
}
