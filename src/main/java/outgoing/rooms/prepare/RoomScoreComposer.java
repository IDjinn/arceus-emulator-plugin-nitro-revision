package outgoing.rooms.prepare;

import networking.packets.IOutgoingPacket;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;


public class RoomScoreComposer implements IOutgoingPacket<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendInt(0, "score");
        writer.appendBoolean(false, "canVote");
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomScoreComposer;
    }
}
