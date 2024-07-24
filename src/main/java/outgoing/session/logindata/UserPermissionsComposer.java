package outgoing.session.logindata;

import networking.packets.IPacketWriter;
import networking.packets.OutgoingPacket;
import networking.packets.IPacketDTO;
import outgoing.OutgoingHeaders;


public class UserPermissionsComposer implements OutgoingPacket<IPacketDTO> {
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
