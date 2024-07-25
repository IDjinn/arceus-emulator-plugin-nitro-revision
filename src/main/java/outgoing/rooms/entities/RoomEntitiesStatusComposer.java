package outgoing.rooms.entities;

import com.google.inject.Inject;
import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.entities.RoomEntitiesStatusDTO;
import serializers.rooms.entities.components.EntityStatusSerializer;

public class RoomEntitiesStatusComposer implements IOutgoingDTOSerializer<RoomEntitiesStatusDTO> {
    private @Inject EntityStatusSerializer entityStatusSerializer;
    @Override
    public void compose(IPacketWriter writer, RoomEntitiesStatusDTO dto) {
        writer.appendInt(dto.entities().size());
        for (var entity : dto.entities()) {
            writer.appendInt(entity.getVirtualId());
            writer.appendInt(entity.getPositionComponent().getPosition().getX());
            writer.appendInt(entity.getPositionComponent().getPosition().getY());
            writer.appendString(String.valueOf(entity.getPositionComponent().getPosition().getZ()));

            writer.appendInt(entity.getPositionComponent().getDirection().ordinal());
            writer.appendInt(entity.getPositionComponent().getDirection().ordinal()); 

            this.entityStatusSerializer.serialize(writer, entity.getStatusComponent());
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomUserStatusComposer;
    }
}
