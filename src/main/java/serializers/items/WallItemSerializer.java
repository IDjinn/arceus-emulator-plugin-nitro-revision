package serializers.items;

import habbo.furniture.FurnitureUsagePolicy;
import habbo.rooms.components.objects.items.floor.IFloorItem;
import habbo.rooms.components.objects.items.wall.IWallItem;
import networking.packets.IPacketSerializer;
import networking.packets.IPacketWriter;

public class WallItemSerializer implements IPacketSerializer<IWallItem> {
    @Override
    public void serialize(IPacketWriter writer, IWallItem wallItem) {
        writer.appendString(String.valueOf(wallItem.getVirtualId()));
        writer.appendInt(wallItem.getFurniture().getSpriteId());
        writer.appendString(wallItem.getWallPosition());
        wallItem.getExtraData().serializeState(writer);
        writer.appendInt(-1, "expiration timeout");
        writer.appendInt(FurnitureUsagePolicy.Controller.ordinal());

        if (wallItem.getOwnerData() != null && wallItem.getOwnerData().isPresent()) {
            var owner = wallItem.getOwnerData().get();
            writer.appendInt(owner.getId());
        } else {
            writer.appendInt(0);
        }
    }
}
