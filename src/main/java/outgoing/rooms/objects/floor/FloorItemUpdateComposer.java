package outgoing.rooms.objects.floor;

import com.google.inject.Inject;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.floor.FloorItemUpdateComposerDTO;
import serializers.items.FloorItemSerializer;


public class FloorItemUpdateComposer implements IOutgoingPacket<FloorItemUpdateComposerDTO> {
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
