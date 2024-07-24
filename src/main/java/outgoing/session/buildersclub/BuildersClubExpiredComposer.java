package outgoing.session.buildersclub;

import networking.packets.IPacketWriter;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketDTO;
import outgoing.OutgoingHeaders;


public class BuildersClubExpiredComposer implements IOutgoingPacket<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendInt(Integer.MAX_VALUE);
        writer.appendInt(0);
        writer.appendInt(100);
        writer.appendInt(Integer.MAX_VALUE);
        writer.appendInt(0);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.BuildersClubExpiredComposer;
    }
}
