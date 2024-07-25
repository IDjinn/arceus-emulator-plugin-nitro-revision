package outgoing.session.habboclub;

import networking.packets.IOutgoingPacket;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;


public class UserClubComposer implements IOutgoingPacket<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendString("HABBO_CLUB".toLowerCase());
        writer.appendInt(0);
        writer.appendInt(0);
        writer.appendInt(0);
        writer.appendInt(0);
        writer.appendBoolean(false);
        writer.appendBoolean(false);
        writer.appendInt(0);
        writer.appendInt(0);
        writer.appendInt(0);
        writer.appendInt(0);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserClubComposer;
    }
}
