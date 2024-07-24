package outgoing.guest;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import networking.packets.IOutgoingPacket;
import outgoing.OutgoingHeaders;


public class SecureLoginOkComposer implements IOutgoingPacket<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.SecureLoginOKComposer;
    }
}
