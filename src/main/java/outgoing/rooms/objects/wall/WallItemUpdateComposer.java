package outgoing.rooms.objects.wall;

import com.google.inject.Inject;
import habbo.furniture.FurnitureUsagePolicy;
import habbo.rooms.components.objects.items.wall.IWallItem;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.wall.WallItemUpdateComposerDTO;
import serializers.items.WallItemSerializer;


public class WallItemUpdateComposer implements IOutgoingPacket<WallItemUpdateComposerDTO> {
    private @Inject WallItemSerializer wallItemSerializer;
    @Override
    public void compose(IPacketWriter writer, WallItemUpdateComposerDTO dto) {]
        this.wallItemSerializer.serialize(writer, dto.wallItem());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.WallItemUpdateComposer;
    }
}
