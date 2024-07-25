package outgoing.rooms.session;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.session.HotelViewComposerDTO;
import packets.outgoing.rooms.session.IHotelViewComposer;


public class HotelViewComposer implements  IHotelViewComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.HotelViewComposer;
    }

    @Override
    public void compose(IPacketWriter writer, HotelViewComposerDTO dto) {
    }
}
