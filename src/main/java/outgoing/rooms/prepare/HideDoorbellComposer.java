package outgoing.rooms.prepare;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.rooms.session.IHideDoorbellComposer;


public class HideDoorbellComposer implements  IHideDoorbellComposer {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.HideDoorbellComposer;
    }
}
