package outgoing.rooms.objects.wall;

import com.google.inject.Inject;
import habbo.furniture.FurnitureUsagePolicy;
import habbo.rooms.components.objects.items.wall.IWallItem;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.wall.RoomWallItemsComposerDTO;
import serializers.items.OwnerItemListSerializer;
import serializers.items.WallItemSerializer;

import java.util.Collection;
import java.util.List;

public class RoomWallItemsComposer implements IOutgoingPacket<RoomWallItemsComposerDTO> {
    private @Inject WallItemSerializer wallItemSerializer;
    private @Inject OwnerItemListSerializer ownerItemListSerializer;
    
    @Override
    public void compose(IPacketWriter writer, RoomWallItemsComposerDTO dto) {
        this.ownerItemListSerializer.serialize(writer, dto.owners());

        writer.appendInt(dto.allItems().size());
        for (var wallItem : dto.allItems()) {
            this.wallItemSerializer.serialize(writer, wallItem);
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomWallItemsComposer;
    }
}
