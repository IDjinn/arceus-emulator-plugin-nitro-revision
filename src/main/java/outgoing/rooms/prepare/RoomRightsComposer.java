package outgoing.rooms.prepare;

import habbo.rooms.RoomRightLevel;
import networking.packets.IOutgoingPacket;


public class RoomRightsComposer extends IOutgoingPacket<U> {
    public RoomRightsComposer(RoomRightLevel level) {
        super(OutgoingHeaders.RoomRightsComposer);
        this.appendInt(level.ordinal());
    }
}
