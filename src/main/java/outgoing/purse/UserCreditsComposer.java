package outgoing.purse;

import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.purse.UserCreditsComposerDTO;


public class UserCreditsComposer implements IOutgoingPacket<UserCreditsComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, UserCreditsComposerDTO dto) {
        writer.appendString(STR."\{dto.value()}");
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserCreditsComposer;
    }
}
