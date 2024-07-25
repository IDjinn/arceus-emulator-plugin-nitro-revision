package outgoing.session.logindata;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.session.logindata.IUserPermissionsComposer;


public class UserPermissionsComposer implements IOutgoingDTOSerializer<IPacketDTO>, IUserPermissionsComposer {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendInt(2);
        writer.appendInt(1);
        writer.appendBoolean(false);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserPermissionsComposer;
    }
}
