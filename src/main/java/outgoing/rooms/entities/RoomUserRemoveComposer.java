package outgoing.rooms.entities;

import habbo.rooms.entities.IRoomEntity;
import networking.packets.IOutgoingPacket;


public class RoomUserRemoveComposer extends IOutgoingPacket<U> {
    public RoomUserRemoveComposer(IRoomEntity roomEntity) {
        super(OutgoingHeaders.RoomUserRemoveComposer);
        this.appendInt(roomEntity.getVirtualId());
    }
}
