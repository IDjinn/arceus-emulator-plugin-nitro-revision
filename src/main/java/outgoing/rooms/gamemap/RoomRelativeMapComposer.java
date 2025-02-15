package outgoing.rooms.gamemap;

import com.google.inject.Inject;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.gamemap.RoomHeightMapComposerDTO;
import packets.dto.outgoing.room.gamemap.RoomRelativeMapComposerDTO;
import packets.outgoing.rooms.gamemap.IRoomRelativeMapComposer;
import serializers.rooms.gamemap.GameMapSerializer;


public class RoomRelativeMapComposer implements  IRoomRelativeMapComposer {
    private @Inject GameMapSerializer gameMapSerializer;

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomRelativeMapComposer;
    }

    @Override
    public void encode(IPacketWriter writer, RoomRelativeMapComposerDTO dto) {
        final var gameMap = dto.roomGameMap();
        writer.appendInt(gameMap.getMapSize() / gameMap.getMaxY());
        writer.appendInt(gameMap.getMapSize());

        for (int y = 0; y < gameMap.getMaxY(); y++) {
            for (int x = 0; x < gameMap.getMaxX(); x++) {
                final var tile = gameMap.getTile(x, y);
                this.gameMapSerializer.serialize(writer, tile);
            }
        }
    }
}
