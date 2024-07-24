package outgoing.rooms.prepare;

import networking.packets.IOutgoingPacket;


public class RoomPaintComposer extends IOutgoingPacket<U> {
    public RoomPaintComposer(String type, String value) {
        super(OutgoingHeaders.RoomPaintComposer);
        this.appendString(type);
        this.appendString(value);
    }
}
