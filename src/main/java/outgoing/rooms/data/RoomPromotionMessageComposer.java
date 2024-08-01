package outgoing.rooms.data;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.data.RoomPromotionMessageComposerDTO;
import packets.outgoing.rooms.data.IRoomPromotionMessageComposer;


public class RoomPromotionMessageComposer implements  IRoomPromotionMessageComposer {

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomPromotionMessageComposer;
    }

    @Override
    public void encode(IPacketWriter writer, RoomPromotionMessageComposerDTO dto) {
        writer.appendInt(-1);
        writer.appendInt(-1);
        writer.appendString("");
        writer.appendInt(0);
        writer.appendInt(0);
        writer.appendString("");
        writer.appendString("");
        writer.appendInt(0);
        writer.appendInt(0);
        writer.appendInt(0);
    }
}
