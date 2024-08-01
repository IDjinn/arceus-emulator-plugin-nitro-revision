package outgoing.rooms.data;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.data.RoomScoreComposerDTO;
import packets.outgoing.rooms.data.IRoomScoreComposer;


public class RoomScoreComposer implements  IRoomScoreComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomScoreComposer;
    }

    @Override
    public void encode(IPacketWriter writer, RoomScoreComposerDTO dto) {
        writer.appendInt(0, "score");
        writer.appendBoolean(false, "canVote");
    }
}
