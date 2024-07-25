package outgoing.rooms.objects.floor;

import com.google.inject.Inject;
import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.floor.AddFloorItemComposerDTO;
import packets.outgoing.rooms.objects.floor.IAddFloorItemComposer;
import serializers.items.FloorItemSerializer;


public class AddFloorItemComposer implements IOutgoingDTOSerializer<AddFloorItemComposerDTO>, IAddFloorItemComposer {
    private @Inject FloorItemSerializer floorItemSerializer;
    @Override
    public void compose(IPacketWriter writer, AddFloorItemComposerDTO dto) {
        this.floorItemSerializer.serialize(writer, dto.floorItem());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.AddFloorItemComposer;
    }
}
