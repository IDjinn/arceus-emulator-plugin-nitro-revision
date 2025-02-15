package incoming.rooms.objects;

import com.google.inject.Singleton;
import habbo.rooms.components.objects.items.floor.IFloorItem;
import networking.client.IClient;
import networking.packets.incoming.IIncomingPacket;
import incoming.IncomingEvent;
import incoming.IncomingHeaders;
import utils.pathfinder.Position;

@Singleton
public class RoomMoveOrRotateFloorItemEvent extends IncomingEvent {
    @Override
    public int getHeaderId() {
        return IncomingHeaders.RoomMoveOrRotateFloorItemEvent;
    }

    @Override
    public void parse(final IIncomingPacket packet, final IClient client) {
        if (client.getHabbo().getRoom() == null) return;

        if (!client.getHabbo().getPlayerEntity().hasRights())
            return;

        final var itemId = packet.readInt();
        var item = client.getHabbo().getRoom().getObjectManager().getItem(itemId);
        if (!(item instanceof IFloorItem floorItem)) return;

        final var x = packet.readInt();
        final var y = packet.readInt();
        final var rotation = packet.readInt();

        client.getHabbo().getRoom().getObjectManager().moveFloorItemTo(client.getHabbo(), floorItem, new Position(x, y),
                rotation);
    }
}
