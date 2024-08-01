package outgoing.rooms.objects.floor;

import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.floor.RemoveFloorItemComposerDTO;
import packets.outgoing.rooms.objects.floor.IRemoveFloorItemComposer;


public class RemoveFloorItemComposer implements  IRemoveFloorItemComposer {
    @Override
    public void encode(IPacketWriter writer, RemoveFloorItemComposerDTO dto) {
        writer.appendString(String.valueOf(dto.floorItem().getVirtualId()));
        writer.appendBoolean(false, "isExpired");
        writer.appendInt(dto.pickupPlayerId());
        writer.appendInt(dto.delay());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RemoveFloorItemComposer;
    }
}
