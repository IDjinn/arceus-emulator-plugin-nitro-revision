package outgoing.rooms.prepare;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.rooms.prepare.IHideDoorbellComposer;


public class HideDoorbellComposer implements IOutgoingDTOSerializer<IPacketDTO>, IHideDoorbellComposer {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.HideDoorbellComposer;
    }
}
