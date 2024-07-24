package outgoing.session.logindata;

import networking.packets.OutgoingPacket;
import networking.packets.PacketDTO;
import networking.packets.PacketWriter;
import outgoing.OutgoingHeaders;


public class NewUserIdentityComposer implements OutgoingPacket<PacketDTO> {
    @Override
    public void compose(PacketWriter writer, PacketDTO dto) {
        writer.appendInt(1);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.NewUserIdentityComposer;
    }
}
