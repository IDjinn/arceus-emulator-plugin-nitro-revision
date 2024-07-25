package serializers.rooms;

import habbo.rooms.IRoom;
import networking.packets.IPacketSerializer;
import networking.packets.IPacketWriter;

public class RoomSerializer implements IPacketSerializer<IRoom> { 
    @Override
    public void serialize(IPacketWriter writer, IRoom room) {
        writer.appendInt(room.getData().getId());
        writer.appendString(room.getData().getName());

        writer.appendInt(room.getData().isPublic() ? 0 : room.getData().getOwnerId());
        writer.appendString(room.getData().isPublic() ? "" : room.getData().getOwnerName());

        writer.appendInt(room.getData().getAccessState().getState());
        writer.appendInt(0);
        writer.appendInt(room.getData().getMaxUsers());
        writer.appendString(room.getData().getDescription());
        writer.appendInt(room.getData().getTradeMode());
        writer.appendInt(room.getData().getScore());
        writer.appendInt(0);
        writer.appendInt(room.getData().getCategoryId()); // this.category

        writer.appendInt(room.getData().getTags().size());

        room.getData().getTags().forEach(writer::appendString);

        int base = 0;

        if (room.getData().getGuildId() > 0) base |= 2;
        if (room.getData().isPromoted()) base |= 4;
        if (!room.getData().isPublic()) base |= 8;
        if (!room.getData().allowPets()) base |= 16;

        writer.appendInt(base);

        // TODO: Write room guild

        // TODO: Write room promotion
    }
}
