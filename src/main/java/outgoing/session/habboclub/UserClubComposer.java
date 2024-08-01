package outgoing.session.habboclub;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.habboclub.UserClubComposerDTO;
import packets.outgoing.session.habboclub.IUserClubComposer;


public class UserClubComposer implements  IUserClubComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserClubComposer;
    }

    @Override
    public void encode(IPacketWriter writer, UserClubComposerDTO dto) {
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
}
