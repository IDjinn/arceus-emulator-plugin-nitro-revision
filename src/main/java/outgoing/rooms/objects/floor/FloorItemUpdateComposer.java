package outgoing.rooms.objects.floor;

import com.google.inject.Inject;
import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.floor.FloorItemUpdateComposerDTO;
import packets.outgoing.rooms.objects.floor.IFloorItemUpdateComposer;
import serializers.items.FloorItemSerializer;


public class FloorItemUpdateComposer implements  IFloorItemUpdateComposer {
    private @Inject FloorItemSerializer floorItemSerializer;
    @Override
    public void compose(IPacketWriter writer, FloorItemUpdateComposerDTO dto) {
        this.floorItemSerializer.serialize(writer, dto.floorItem());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.FloorItemUpdateComposer;
    }
}
