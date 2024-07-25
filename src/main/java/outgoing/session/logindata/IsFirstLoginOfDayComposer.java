package outgoing.session.logindata;


import networking.packets.IOutgoingPacket;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;

public class IsFirstLoginOfDayComposer implements IOutgoingPacket<IPacketDTO> {
    @Override
    public void compose(final IPacketWriter writer, final IPacketDTO dto) {
        writer.appendBoolean(true);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.IsFirstLoginOfDayComposer;
    }
}
