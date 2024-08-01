package outgoing.session.calendar;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.calendar.AdventCalendarDataComposerDTO;
import packets.outgoing.session.calendar.IAdventCalendarDataComposer;


public class AdventCalendarDataComposer implements IAdventCalendarDataComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.AdventCalendarDataComposer;
    }

    @Override
    public void encode(IPacketWriter writer, AdventCalendarDataComposerDTO dto) {
        writer.appendString("xmas14");
        writer.appendString("");
        writer.appendInt(0);
        writer.appendInt(0);
        writer.appendInt(0);
        writer.appendInt(0);
    }
}
