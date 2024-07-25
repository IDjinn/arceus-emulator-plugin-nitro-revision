package outgoing.rooms.gamemap;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.gamemap.RoomHeightMapComposerDTO;
import packets.outgoing.rooms.gamemap.IRoomHeightMapComposer;


public class RoomHeightMapComposer implements  IRoomHeightMapComposer {
    @Override
    public void compose(IPacketWriter writer, RoomHeightMapComposerDTO dto) {
        writer.appendBoolean(true, "scale (true ? 32 : 64");
        writer.appendInt(1, "wallHeight"); // TODO this
        writer.appendString(dto.roomGameMap().getModelMap());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomHeightMapComposer;
    }
}
