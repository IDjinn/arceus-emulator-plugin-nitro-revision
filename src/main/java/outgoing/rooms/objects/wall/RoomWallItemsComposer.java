package outgoing.rooms.objects.wall;

import habbo.furniture.FurnitureUsagePolicy;
import habbo.rooms.components.objects.items.wall.IWallItem;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.wall.RoomWallItemsComposerDTO;

import java.util.Collection;
import java.util.List;

public class RoomWallItemsComposer implements IOutgoingPacket<RoomWallItemsComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, RoomWallItemsComposerDTO dto) {
        writer.appendInt(dto.owners().size());
        for (var i = 0; i < dto.owners().size(); i++) {
            writer.appendInt(i);
            writer.appendString(dto.owners().get(i));
        }

        writer.appendInt(dto.allItems().size());
        for (var wallItem : dto.allItems()) {
            writer.appendString(String.valueOf(wallItem.getVirtualId()));
            writer.appendInt(wallItem.getFurniture().getSpriteId());
            writer.appendString(wallItem.getWallPosition());
            wallItem.getExtraData().serializeState(writer);
            writer.appendInt(-1, "expiration timeout");
            writer.appendInt(FurnitureUsagePolicy.Controller.ordinal()); // TODO:FURNITURE USAGE

            if (wallItem.getOwnerData() != null && wallItem.getOwnerData().isPresent()) {
                var owner = wallItem.getOwnerData().get();
                writer.appendInt(owner.getId());
            } else {
                writer.appendInt(0);
            }
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomWallItemsComposer;
    }
}
