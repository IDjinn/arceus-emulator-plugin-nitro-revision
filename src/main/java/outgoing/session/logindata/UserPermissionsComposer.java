package outgoing.session.logindata;

import networking.packets.IOutgoingPacket;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;


public class UserPermissionsComposer implements IOutgoingPacket<IPacketDTO> {
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
