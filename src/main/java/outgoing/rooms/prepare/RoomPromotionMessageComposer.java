package outgoing.rooms.prepare;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.rooms.prepare.IRoomPromotionMessageComposer;


public class RoomPromotionMessageComposer implements IOutgoingDTOSerializer<IPacketDTO>, IRoomPromotionMessageComposer {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
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

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomPromotionMessageComposer;
    }
}
