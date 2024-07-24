package outgoing.rooms.objects.floor;

import habbo.rooms.components.objects.items.floor.IFloorItem;
import networking.packets.IOutgoingPacket;


public class RemoveFloorItemComposer extends IOutgoingPacket<U> {
    public RemoveFloorItemComposer(IFloorItem floorItem, int pickupPlayerId, int delay) {
        super(OutgoingHeaders.RemoveFloorItemComposer);

        this.appendString(String.valueOf(floorItem.getVirtualId()));
        this.appendBoolean(false, "isExpired");
        this.appendInt(pickupPlayerId);
        this.appendInt(delay);
    }

    public RemoveFloorItemComposer(IFloorItem floorItem, int pickupPlayerId) {
        this(floorItem, pickupPlayerId, 0);
    }
}
