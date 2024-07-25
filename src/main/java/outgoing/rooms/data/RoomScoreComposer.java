package outgoing.rooms.data;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.rooms.data.IRoomScoreComposer;


public class RoomScoreComposer implements  IRoomScoreComposer {
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
