package outgoing.rooms.prepare;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.rooms.session.IHotelViewComposer;


public class HotelViewComposer implements  IHotelViewComposer {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.HotelViewComposer;
    }
}
