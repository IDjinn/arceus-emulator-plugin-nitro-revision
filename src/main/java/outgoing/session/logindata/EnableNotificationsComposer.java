package outgoing.session.logindata;


import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.logindata.EnableNotificationsComposerDTO;
import packets.outgoing.session.logindata.IEnableNotificationsComposer;

public class EnableNotificationsComposer implements  IEnableNotificationsComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.EnableNotificationsComposer;
    }

    @Override
    public void encode(IPacketWriter writer, EnableNotificationsComposerDTO dto) {
        writer.appendBoolean(true);
    }
}
