package outgoing.session.logindata;

import networking.packets.IPacketWriter;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketDTO;
import outgoing.OutgoingHeaders;


public class NewUserIdentityComposer implements IOutgoingPacket<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendInt(1);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.NewUserIdentityComposer;
    }
}
