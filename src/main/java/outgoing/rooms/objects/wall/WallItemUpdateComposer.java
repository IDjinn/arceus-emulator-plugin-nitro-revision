package outgoing.rooms.objects.wall;

import habbo.furniture.FurnitureUsagePolicy;
import habbo.rooms.components.objects.items.wall.IWallItem;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.items.wall.WallItemUpdateComposerDTO;


public class WallItemUpdateComposer implements IOutgoingPacket<WallItemUpdateComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, WallItemUpdateComposerDTO dto) {
        final var wallItem = dto.wallItem();

        writer.appendString(String.valueOf(wallItem.getVirtualId()));
        writer.appendInt(wallItem.getFurniture().getSpriteId());
        writer.appendString(wallItem.getWallPosition());
        wallItem.getExtraData().serializeState(writer);
        writer.appendInt(-1, "rent?");
        writer.appendInt(FurnitureUsagePolicy.Everyone.ordinal()); // TODO
        writer.appendInt(wallItem.getOwnerData().isPresent() ? wallItem.getOwnerData().get().getId() : -1);
        writer.appendString(wallItem.getOwnerData().isPresent() ? wallItem.getOwnerData().get().getUsername() : "");
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.WallItemUpdateComposer;
    }
}
