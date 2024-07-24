package outgoing.rooms.prepare;

import networking.packets.IOutgoingPacket;


public class RoomModelComposer extends IOutgoingPacket<U> {
    public RoomModelComposer(String modelName, int roomId) {
        super(OutgoingHeaders.RoomModelComposer);
        this.appendString(modelName);
        this.appendInt(roomId);
    }
}
