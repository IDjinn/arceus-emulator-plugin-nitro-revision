package outgoing.session.logindata;


import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.session.logindata.IIsFirstLoginOfDayComposer;

public class IsFirstLoginOfDayComposer implements IOutgoingDTOSerializer<IPacketDTO>, IIsFirstLoginOfDayComposer {
    @Override
    public void compose(final IPacketWriter writer, final IPacketDTO dto) {
        writer.appendBoolean(true);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.IsFirstLoginOfDayComposer;
    }
}
