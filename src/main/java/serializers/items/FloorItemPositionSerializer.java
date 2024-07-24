package serializers.items;

import habbo.rooms.components.objects.items.floor.IFloorItem;
import networking.packets.IPacketSerializer;
import networking.packets.IPacketWriter;

public class FloorItemPositionSerializer implements IPacketSerializer<IFloorItem> {
    @Override
    public void serialize(IPacketWriter writer, IFloorItem item) {
        writer
                .appendInt(item.getPosition().getX())
                .appendInt(item.getPosition().getY())
                .appendInt(item.getRotation())
                .appendString(Double.toString(item.getPosition().getZ()))
                .appendString(Double.toString(item.getFurniture().getStackHeight()));
    }
}
