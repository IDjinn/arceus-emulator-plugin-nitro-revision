package outgoing.session.logindata;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.session.logindata.INewUserIdentityComposer;


public class NewUserIdentityComposer implements  INewUserIdentityComposer {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendInt(1);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.NewUserIdentityComposer;
    }
}
