package outgoing.friends;

import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.messenger.MessengerInitComposerDTO;
import packets.outgoing.friends.IMessengerInitComposer;


public class MessengerInitComposer implements IMessengerInitComposer {
    @Override
    public void encode(IPacketWriter writer, MessengerInitComposerDTO dto) {
        writer.appendInt(Integer.MAX_VALUE);
        writer.appendInt(1337);
        writer.appendInt(Integer.MAX_VALUE);
        writer.appendInt(0);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.MessengerInitComposer;
    }
}
