package outgoing.friends;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.friends.IMessengerInitComposer;


public class MessengerInitComposer implements IMessengerInitComposer {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
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
