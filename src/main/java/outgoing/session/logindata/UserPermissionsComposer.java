package outgoing.session.logindata;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.logindata.UserPermissionsComposerDTO;
import packets.outgoing.session.logindata.IUserPermissionsComposer;


public class UserPermissionsComposer implements  IUserPermissionsComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserPermissionsComposer;
    }

    @Override
    public void compose(IPacketWriter writer, UserPermissionsComposerDTO dto) {
        writer.appendInt(2);
        writer.appendInt(1);
        writer.appendBoolean(false);
    }
}
