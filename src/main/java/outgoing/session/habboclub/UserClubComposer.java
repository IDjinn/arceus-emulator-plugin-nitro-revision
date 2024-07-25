package outgoing.session.habboclub;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.session.habboclub.IUserClubComposer;


public class UserClubComposer implements IOutgoingDTOSerializer<IPacketDTO>, IUserClubComposer {
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
