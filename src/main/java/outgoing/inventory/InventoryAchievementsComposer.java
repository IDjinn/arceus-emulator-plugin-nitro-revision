package outgoing.inventory;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.inventory.IInventoryAchievementsComposer;


public class InventoryAchievementsComposer implements  IInventoryAchievementsComposer {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendInt(0);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.InventoryAchievementsComposer;
    }
}
