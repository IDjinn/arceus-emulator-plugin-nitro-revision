package serializers.items;

import habbo.furniture.FurnitureUsagePolicy;
import habbo.rooms.components.objects.items.floor.IFloorItem;
import networking.packets.IPacketSerializer;
import networking.packets.IPacketWriter;

public class FloorItemSerializer implements IPacketSerializer<IFloorItem> {
    @Override
    public void serialize(IPacketWriter writer, IFloorItem floorItem) {
        writer
                .appendString(String.valueOf(floorItem.getVirtualId()))
                .appendInt(floorItem.getFurniture().getSpriteId())
                .appendInt(floorItem.getPosition().getX())
                .appendInt(floorItem.getPosition().getY())
                .appendInt(floorItem.getRotation())
                .appendString(Double.toString(floorItem.getPosition().getZ()))
                .appendString(Double.toString(floorItem.getFurniture().getStackHeight()));
        
        writer.appendInt(1, "gift stuff (extra data as int?)");
        floorItem.getExtraData().serialize(this);
        writer.appendInt(-1, "expires at");
        writer.appendInt(FurnitureUsagePolicy.Everyone.ordinal());
        writer.appendInt(floorItem.getOwnerData().isPresent() ? floorItem.getOwnerData().get().getId() : 0);
        writer.appendString(floorItem.getRoom().getData().isPublic() || floorItem.getOwnerData().isEmpty() ? "admin" : floorItem.getOwnerData().get().getUsername());
    }
}
