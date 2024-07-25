package outgoing.rooms.entities.chat;

import habbo.rooms.entities.IRoomEntity;

import java.util.Collections;
import java.util.Set;

public class RoomUserTalkMessageComposer extends IOutgoingDTOSerializer<U> {
    public RoomUserTalkMessageComposer(final IRoomEntity entity,
                                       final String message) {
        this(entity, message, 0, 0, Collections.emptySet());
    }

    public RoomUserTalkMessageComposer(final IRoomEntity entity,
                                       final String message,
                                       final int emotion,
                                       final int bubble) {
        this(entity, message, emotion, bubble, Collections.emptySet());
    }

    public RoomUserTalkMessageComposer(final IRoomEntity entity,
                                       final String message,
                                       final int emotion,
                                       final int bubble,
                                       final Set<String> urls) {
        super(OutgoingHeaders.RoomUserTalkComposer);

        this.appendInt(entity.getVirtualId());
        this.appendString(message);
        this.appendInt(emotion);
        this.appendInt(bubble);
        this.appendInt(urls.size());
        for (var url : urls) {
            this.appendString(url);
        }
        this.appendInt(message.length());
    }
}
