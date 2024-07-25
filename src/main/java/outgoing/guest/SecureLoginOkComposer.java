package outgoing.guest;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.guest.ISecureLoginOkComposer;


public class SecureLoginOkComposer implements ISecureLoginOkComposer {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.SecureLoginOKComposer;
    }
}
