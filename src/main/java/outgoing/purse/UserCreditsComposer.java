package outgoing.purse;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.purse.UserCreditsComposerDTO;
import packets.outgoing.purse.IUserCreditsComposer;


public class UserCreditsComposer implements  IUserCreditsComposer {
    @Override
    public void compose(IPacketWriter writer, UserCreditsComposerDTO dto) {
        writer.appendString(STR."\{dto.value()}");
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserCreditsComposer;
    }
}
