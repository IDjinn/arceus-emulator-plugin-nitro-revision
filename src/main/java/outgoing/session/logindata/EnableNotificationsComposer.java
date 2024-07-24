package outgoing.session.logindata;


import networking.packets.IPacketWriter;
import networking.packets.OutgoingPacket;
import networking.packets.IPacketDTO;
import outgoing.OutgoingHeaders;

public class EnableNotificationsComposer implements OutgoingPacket<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendBoolean(true);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.EnableNotificationsComposer;
    }
}
