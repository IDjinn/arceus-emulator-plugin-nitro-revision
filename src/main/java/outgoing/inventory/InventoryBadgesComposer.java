package outgoing.inventory;

import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.inventory.InventoryBadgesComposerDTO;
import packets.outgoing.inventory.IInventoryBadgesComposer;

public class InventoryBadgesComposer implements  IInventoryBadgesComposer {
    @Override
    public void encode(IPacketWriter writer, InventoryBadgesComposerDTO dto) {
        writer.appendInt(dto.badges().size());
        for (final var badge : dto.badges().values()) {
            writer.appendInt(badge.getSlot().orElse(0));
            writer.appendString(badge.getCode());
        }
        
        for (final var badge : dto.profileBadges().values()) {
            writer.appendInt(badge.getSlot().orElse(0));
            writer.appendString(badge.getCode());
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.InventoryBadgesComposer;
    }
}
