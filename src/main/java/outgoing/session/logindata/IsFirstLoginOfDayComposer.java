package outgoing.session.logindata;


import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.logindata.IsFirstLoginOfDayComposerDTO;
import packets.outgoing.session.logindata.IIsFirstLoginOfDayComposer;

public class IsFirstLoginOfDayComposer implements  IIsFirstLoginOfDayComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.IsFirstLoginOfDayComposer;
    }

    @Override
    public void compose(IPacketWriter writer, IsFirstLoginOfDayComposerDTO dto) {
        writer.appendBoolean(true);
    }
}
