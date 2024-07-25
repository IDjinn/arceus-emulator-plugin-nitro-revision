package outgoing.session.logindata;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.logindata.MeMenuSettingsComposerDTO;
import packets.outgoing.session.logindata.IMeMenuSettingsComposer;

public class MeMenuSettingsComposer implements  IMeMenuSettingsComposer { // TODO: USER CONFIGURATION SETTINGS
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.MeMenuSettingsComposer;
    }

    @Override
    public void compose(IPacketWriter writer, MeMenuSettingsComposerDTO dto) {
        writer.appendInt(100);
        writer.appendInt(100);
        writer.appendInt(100);
        writer.appendBoolean(false);
        writer.appendBoolean(false);
        writer.appendBoolean(false);
        writer.appendInt(0);
        writer.appendInt(0);
    }
}
