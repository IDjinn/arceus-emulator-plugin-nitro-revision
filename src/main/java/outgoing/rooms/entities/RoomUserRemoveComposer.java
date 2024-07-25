package outgoing.rooms.entities;

import habbo.rooms.entities.IRoomEntity;


public class RoomUserRemoveComposer extends IOutgoingDTOSerializer<U> {
    public RoomUserRemoveComposer(IRoomEntity roomEntity) {
        super(OutgoingHeaders.RoomUserRemoveComposer);
        this.appendInt(roomEntity.getVirtualId());
    }
}
