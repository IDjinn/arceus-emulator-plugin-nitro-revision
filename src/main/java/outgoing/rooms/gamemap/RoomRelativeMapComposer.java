package outgoing.rooms.gamemap;

import com.google.inject.Inject;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.gamemap.RoomHeightMapComposerDTO;
import serializers.rooms.gamemap.GameMapSerializer;


public class RoomRelativeMapComposer implements IOutgoingPacket<RoomHeightMapComposerDTO> {
    private @Inject GameMapSerializer gameMapSerializer;
    @Override
    public void compose(IPacketWriter writer, RoomHeightMapComposerDTO dto) {
        final var gameMap = dto.roomGameMap();
        writer.appendInt(gameMap.getMapSize() / gameMap.getMaxY());
        writer.appendInt(gameMap.getMapSize());

        for (int y = 0; y < gameMap.getMaxY(); y++) {
            for (int x = 0; x < gameMap.getMaxX(); x++) {
                final var tile = gameMap.getTile(x, y);
                this.gameMapSerializer.serializeTileHeight(writer, tile);
            }
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomRelativeMapComposer;
    }
}
