package outgoing.rooms.gamemap;

import com.google.inject.Inject;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.gamemap.UpdateStackHeightComposerDTO;
import packets.outgoing.rooms.gamemap.IUpdateStackHeightComposer;
import serializers.rooms.gamemap.GameMapSerializer;

public class UpdateStackHeightComposer implements  IUpdateStackHeightComposer {
    private @Inject GameMapSerializer gameMapSerializer;
    @Override
    public void encode(IPacketWriter writer, UpdateStackHeightComposerDTO dto) {
        writer.appendInt(dto.tiles().size());
        for (final var tile : dto.tiles()) {
            writer.appendInt(tile.getX());
            writer.appendInt(tile.getY());
            this.gameMapSerializer.serialize(writer, tile);
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UpdateStackHeightComposer;
    }
}
