package outgoing.rooms.objects.wall;

import habbo.rooms.components.objects.items.wall.IWallItem;
import networking.packets.IOutgoingPacket;


public class RemoveWallItemComposer extends IOutgoingPacket<U> {

    public RemoveWallItemComposer(IWallItem wallItem, int pickupPlayerId) {
        super(OutgoingHeaders.RemoveWallItemComposer);
        this.appendString(String.valueOf(wallItem.getVirtualId()));
        this.appendInt(pickupPlayerId);
    }
}
