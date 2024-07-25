package outgoing.rooms.objects.wall;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.wall.RemoveWallItemComposerDTO;
import packets.outgoing.rooms.objects.wall.IRemoveWallItemComposer;


public class RemoveWallItemComposer implements IOutgoingDTOSerializer<RemoveWallItemComposerDTO>, IRemoveWallItemComposer {
    @Override
    public void compose(IPacketWriter writer, RemoveWallItemComposerDTO dto) {
        writer.appendString(String.valueOf(dto.wallItem().getVirtualId()));
        writer.appendInt(dto.pickupPlayerId());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RemoveWallItemComposer;
    }
}
