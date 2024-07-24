package outgoing.rooms.prepare;

import networking.packets.IOutgoingPacket;


public class HotelViewComposer extends IOutgoingPacket<U> {
    public HotelViewComposer() {
        super(OutgoingHeaders.HotelViewComposer);
    }
}
