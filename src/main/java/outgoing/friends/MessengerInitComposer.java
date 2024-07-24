package outgoing.friends;

import habbo.habbos.IHabbo;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import networking.packets.OutgoingPacket;
import outgoing.OutgoingHeaders;


public class MessengerInitComposer implements OutgoingPacket<IPacketDTO> {
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
