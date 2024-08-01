package outgoing.session.buildersclub;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.buildersclub.BuildersClubExpiredComposerDTO;
import packets.outgoing.session.buildersclub.IBuildersClubExpiredComposer;


public class BuildersClubExpiredComposer implements  IBuildersClubExpiredComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.BuildersClubExpiredComposer;
    }

    @Override
    public void encode(IPacketWriter writer, BuildersClubExpiredComposerDTO dto) {
        writer.appendInt(Integer.MAX_VALUE);
        writer.appendInt(0);
        writer.appendInt(100);
        writer.appendInt(Integer.MAX_VALUE);
        writer.appendInt(0);
    }
}
