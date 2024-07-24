package outgoing.session.calendar;

import networking.packets.IPacketWriter;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketDTO;
import outgoing.OutgoingHeaders;


public class AdventCalendarDataComposer implements IOutgoingPacket<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
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
