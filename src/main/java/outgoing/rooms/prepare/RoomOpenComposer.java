package outgoing.rooms.prepare;

import networking.packets.IOutgoingPacket;


public class RoomOpenComposer extends IOutgoingPacket<U> {

    public RoomOpenComposer() {
        super(OutgoingHeaders.RoomOpenComposer);
    }
}
