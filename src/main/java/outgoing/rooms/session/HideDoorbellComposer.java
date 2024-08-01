package outgoing.rooms.session;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.session.HideDoorbellComposerDTO;
import packets.outgoing.rooms.session.IHideDoorbellComposer;


public class HideDoorbellComposer implements  IHideDoorbellComposer {

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.HideDoorbellComposer;
    }

    @Override
    public void encode(IPacketWriter writer, HideDoorbellComposerDTO dto) {
        
    }
}
