package outgoing.inventory;

import habbo.habbos.data.badges.IHabboBadge;
import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.inventory.InventoryBadgesComposerDTO;

public class InventoryBadgesComposer implements IOutgoingPacket<InventoryBadgesComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, InventoryBadgesComposerDTO dto) {
        writer.appendInt(dto.badges().size());
        for (IHabboBadge badge : dto.badges().values()) {
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
