package outgoing.inventory;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import networking.packets.IOutgoingPacket;
import outgoing.OutgoingHeaders;


public class InventoryAchievementsComposer implements IOutgoingPacket<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendInt(0);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.InventoryAchievementsComposer;
    }
}
