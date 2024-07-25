package outgoing.guest;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.guest.SecureLoginOkComposerDTO;
import packets.outgoing.guest.ISecureLoginOkComposer;


public class SecureLoginOkComposer implements ISecureLoginOkComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.SecureLoginOKComposer;
    }

    @Override
    public void compose(IPacketWriter writer, SecureLoginOkComposerDTO dto) {
        
    }
}
