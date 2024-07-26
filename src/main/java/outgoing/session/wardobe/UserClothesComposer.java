package outgoing.session.wardobe;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import networking.packets.outgoing.IOutgoingEvent;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.wardobe.UserClothesComposerDTO;
import packets.outgoing.session.wardobe.IUserClothesComposer;


public class UserClothesComposer implements IUserClothesComposer {
    @Override
    public void compose(IPacketWriter writer, UserClothesComposerDTO dto) {
        writer.appendInt(0);
        writer.appendInt(0);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserClothesComposer;
    }
}
