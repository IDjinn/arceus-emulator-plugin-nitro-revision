package outgoing.session.logindata;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.logindata.UserEffectsListComposerDTO;
import packets.outgoing.session.logindata.IUserEffectsListComposer;


public class UserEffectsListComposer implements  IUserEffectsListComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserEffectsListComposer;
    }

    @Override
    public void encode(IPacketWriter writer, UserEffectsListComposerDTO dto) {
        writer.appendInt(0);
    }
}
