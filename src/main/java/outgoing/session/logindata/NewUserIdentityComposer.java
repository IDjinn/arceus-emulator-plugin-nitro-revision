package outgoing.session.logindata;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.logindata.NewUserIdentityComposerDTO;
import packets.outgoing.session.logindata.INewUserIdentityComposer;


public class NewUserIdentityComposer implements  INewUserIdentityComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.NewUserIdentityComposer;
    }

    @Override
    public void encode(IPacketWriter writer, NewUserIdentityComposerDTO dto) {
        writer.appendInt(1);
    }
}
