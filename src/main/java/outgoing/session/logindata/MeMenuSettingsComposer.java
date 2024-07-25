package outgoing.session.logindata;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.session.logindata.IMeMenuSettingsComposer;

public class MeMenuSettingsComposer implements  IMeMenuSettingsComposer { // TODO: USER CONFIGURATION SETTINGS
    @Override
    public void compose(final IPacketWriter writer, final IPacketDTO dto) {
        writer.appendInt(100);
        writer.appendInt(100);
        writer.appendInt(100);
        writer.appendBoolean(false);
        writer.appendBoolean(false);
        writer.appendBoolean(false);
        writer.appendInt(0);
        writer.appendInt(0);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.MeMenuSettingsComposer;
    }
}
