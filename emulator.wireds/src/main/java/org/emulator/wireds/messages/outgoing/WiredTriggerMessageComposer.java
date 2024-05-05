package org.emulator.wireds.messages.outgoing;

import networking.packets.OutgoingPacket;
import org.emulator.wireds.boxes.triggers.WiredTrigger;
import packets.outgoing.OutgoingHeaders;

public class WiredTriggerMessageComposer extends OutgoingPacket {
    public WiredTriggerMessageComposer(final WiredTrigger wiredTrigger) {
        super(OutgoingHeaders.WiredTriggerDataComposer);

        WiredItemWriter.serialize(this, wiredTrigger);
    }
}
