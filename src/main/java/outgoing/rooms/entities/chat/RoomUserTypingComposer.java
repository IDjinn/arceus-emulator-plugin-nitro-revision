package outgoing.rooms.entities.chat;

import habbo.rooms.entities.IRoomEntity;
import networking.packets.outgoing.IOutgoingDTOSerializer;


public class RoomUserTypingComposer extends IOutgoingDTOSerializer<U> {
    public RoomUserTypingComposer(IRoomEntity entity, boolean isTyping) {
        super(OutgoingHeaders.RoomUserTypingComposer);

        this.appendInt(entity.getVirtualId());
        this.appendInt(isTyping ? 1 : 0);
    }
}
