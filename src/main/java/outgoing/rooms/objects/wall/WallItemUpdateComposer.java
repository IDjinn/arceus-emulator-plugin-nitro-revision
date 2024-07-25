package outgoing.rooms.objects.wall;

import com.google.inject.Inject;
import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.wall.WallItemUpdateComposerDTO;
import packets.outgoing.rooms.objects.wall.IWallItemUpdateComposer;
import serializers.items.WallItemSerializer;


public class WallItemUpdateComposer implements IOutgoingDTOSerializer<WallItemUpdateComposerDTO>, IWallItemUpdateComposer {
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
