package outgoing.session.buildersclub;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.session.buildersclub.IBuildersClubExpiredComposer;


public class BuildersClubExpiredComposer implements IOutgoingDTOSerializer<IPacketDTO>, IBuildersClubExpiredComposer {
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
