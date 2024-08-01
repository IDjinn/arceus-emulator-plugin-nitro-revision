package outgoing.inventory;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.inventory.InventoryAchievementsComposerDTO;
import packets.outgoing.inventory.IInventoryAchievementsComposer;


public class InventoryAchievementsComposer implements  IInventoryAchievementsComposer {

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.InventoryAchievementsComposer;
    }

    @Override
    public void encode(IPacketWriter writer, InventoryAchievementsComposerDTO dto) {
        writer.appendInt(0);
    }
}
