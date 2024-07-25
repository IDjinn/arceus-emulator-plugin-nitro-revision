package outgoing.rooms.objects.floor;

import com.google.inject.Inject;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.floor.RoomFloorItemsComposerDTO;
import serializers.items.FloorItemSerializer;
import serializers.items.OwnerItemListSerializer;

public class RoomFloorItemsComposer implements IOutgoingPacket<RoomFloorItemsComposerDTO> {
    private @Inject FloorItemSerializer floorItemSerializer;
    private @Inject OwnerItemListSerializer ownerItemListSerializer;

    @Override
    public void compose(IPacketWriter writer, RoomFloorItemsComposerDTO dto) {
        this.ownerItemListSerializer.serialize(writer, dto.owners());
        
        writer.appendInt(dto.allItems().size());
        for (var item : dto.allItems()) {
            this.floorItemSerializer.serialize(writer, item);
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomFloorItemsComposer;
    }
}