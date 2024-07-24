package outgoing.session.logindata;

import networking.packets.IPacketWriter;
import networking.packets.OutgoingPacket;
import networking.packets.IPacketDTO;
import outgoing.OutgoingHeaders;

public class MeMenuSettingsComposer implements OutgoingPacket<IPacketDTO> { // TODO: USER CONFIGURATION SETTINGS
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
