package serializers.items;

import habbo.furniture.FurnitureUsagePolicy;
import habbo.rooms.components.objects.items.floor.IFloorItem;
import networking.packets.IPacketSerializer;
import networking.packets.IPacketWriter;

import java.util.List;

public class OwnerItemListSerializer implements IPacketSerializer<List<String>> {
    @Override
    public void serialize(IPacketWriter writer, List<String> owners) {
        writer.appendInt(owners.size());
        for (var i = 0; i < owners.size(); i++) {
            writer.appendInt(i);
            writer.appendString(owners.get(i));
        }
    }
}
