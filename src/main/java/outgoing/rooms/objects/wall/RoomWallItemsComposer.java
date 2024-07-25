package outgoing.rooms.objects.wall;

import com.google.inject.Inject;
import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.wall.RoomWallItemsComposerDTO;
import packets.outgoing.rooms.objects.wall.IRoomWallItemsComposer;
import serializers.items.OwnerItemListSerializer;
import serializers.items.WallItemSerializer;

public class RoomWallItemsComposer implements IOutgoingDTOSerializer<RoomWallItemsComposerDTO>, IRoomWallItemsComposer {
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
