package outgoing.rooms.entities;

import habbo.rooms.entities.IRoomEntity;
import networking.packets.IOutgoingPacket;

import java.util.List;

public class RoomEntitiesComposer extends IOutgoingPacket<U> {
    public RoomEntitiesComposer(IRoomEntity entity) {
        super(OutgoingHeaders.RoomEntitiesComposer);
        this.appendInt(1);
        entity.serialize(this);
    }

    public RoomEntitiesComposer(List<? extends IRoomEntity> entities) {
        super(OutgoingHeaders.RoomEntitiesComposer);
        this.appendInt(entities.size());
        for (IRoomEntity entity : entities) {
            entity.serialize(this);
        }
    }
}
