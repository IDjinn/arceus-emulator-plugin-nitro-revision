package outgoing.session.calendar;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.session.calendar.IAdventCalendarDataComposer;


public class AdventCalendarDataComposer implements  IAdventCalendarDataComposer {
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
