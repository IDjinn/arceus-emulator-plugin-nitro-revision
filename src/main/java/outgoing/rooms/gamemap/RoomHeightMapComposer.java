package outgoing.rooms.gamemap;

import habbo.rooms.components.gamemap.IRoomGameMap;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.gamemap.RoomHeightMapComposerDTO;


public class RoomHeightMapComposer implements IOutgoingPacket<RoomHeightMapComposerDTO> {
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
