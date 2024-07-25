package outgoing.rooms.objects.wall;

import com.google.inject.Inject;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.wall.AddWallItemComposerDTO;
import packets.outgoing.rooms.objects.wall.IAddWallItemComposer;
import serializers.items.WallItemSerializer;


public class AddWallItemComposer implements  IAddWallItemComposer {
    private @Inject WallItemSerializer wallItemSerializer;

    @Override
    public void compose(IPacketWriter writer, AddWallItemComposerDTO dto) {
        this.wallItemSerializer.serialize(writer, dto.wallItem());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.AddWallItemComposer;
    }
}
