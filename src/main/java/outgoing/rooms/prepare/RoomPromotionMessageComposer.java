package outgoing.rooms.prepare;

import networking.packets.IOutgoingPacket;


public class RoomPromotionMessageComposer extends IOutgoingPacket<U> {
    public RoomPromotionMessageComposer() {
        super(OutgoingHeaders.RoomPromotionMessageComposer);
        this.appendInt(-1);
        this.appendInt(-1);
        this.appendString("");
        this.appendInt(0);
        this.appendInt(0);
        this.appendString("");
        this.appendString("");
        this.appendInt(0);
        this.appendInt(0);
        this.appendInt(0);
    }
}
