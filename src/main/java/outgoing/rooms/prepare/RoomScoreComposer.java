package outgoing.rooms.prepare;

import networking.packets.IOutgoingPacket;


public class RoomScoreComposer extends IOutgoingPacket<U> {
    public RoomScoreComposer(int score, boolean canVote) {
        super(OutgoingHeaders.RoomScoreComposer);
        this.appendInt(score);
        this.appendBoolean(canVote);
    }
}
