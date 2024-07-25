package outgoing.rooms.gamemap;

import com.google.inject.Inject;
import habbo.rooms.components.gamemap.IRoomTile;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.gamemap.UpdateStackHeightComposerDTO;
import serializers.rooms.gamemap.GameMapSerializer;

import java.util.List;

public class UpdateStackHeightComposer implements IOutgoingPacket<UpdateStackHeightComposerDTO> {
    private @Inject GameMapSerializer gameMapSerializer;
    @Override
    public void compose(IPacketWriter writer, UpdateStackHeightComposerDTO dto) {
        writer.appendInt(dto.tiles().size());
        for (final var tile : dto.tiles()) {
            writer.appendInt(tile.getX());
            writer.appendInt(tile.getY());
            this.gameMapSerializer.serializeTileHeight(writer, tile);
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UpdateStackHeightComposer;
    }
}
