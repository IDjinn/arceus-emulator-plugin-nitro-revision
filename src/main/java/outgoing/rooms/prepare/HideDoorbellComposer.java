package outgoing.rooms.prepare;

import networking.packets.IOutgoingPacket;


public class HideDoorbellComposer extends IOutgoingPacket<U> {
    public HideDoorbellComposer() {
        super(OutgoingHeaders.HideDoorbellComposer);
    }
}
