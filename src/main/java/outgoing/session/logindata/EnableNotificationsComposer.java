package outgoing.session.logindata;


import networking.packets.OutgoingPacket;
import networking.packets.PacketDTO;
import networking.packets.PacketWriter;
import outgoing.OutgoingHeaders;

public class EnableNotificationsComposer implements OutgoingPacket<PacketDTO> {
    @Override
    public void compose(PacketWriter writer, PacketDTO dto) {
        writer.appendBoolean(true);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.EnableNotificationsComposer;
    }
}
