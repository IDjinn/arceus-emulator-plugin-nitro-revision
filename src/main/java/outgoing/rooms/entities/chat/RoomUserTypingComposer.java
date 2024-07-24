package outgoing.rooms.entities.chat;

import habbo.rooms.entities.IRoomEntity;
import networking.packets.IOutgoingPacket;


public class RoomUserTypingComposer extends IOutgoingPacket<U> {
    public RoomUserTypingComposer(IRoomEntity entity, boolean isTyping) {
        super(OutgoingHeaders.RoomUserTypingComposer);

        this.appendInt(entity.getVirtualId());
        this.appendInt(isTyping ? 1 : 0);
    }
}
