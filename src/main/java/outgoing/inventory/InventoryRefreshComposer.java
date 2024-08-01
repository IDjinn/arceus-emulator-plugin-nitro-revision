package outgoing.inventory;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.inventory.InventoryRefreshComposerDTO;
import packets.outgoing.inventory.IInventoryRefreshComposer;


public class InventoryRefreshComposer implements  IInventoryRefreshComposer {

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.InventoryRefreshComposer;
    }

    @Override
    public void encode(IPacketWriter writer, InventoryRefreshComposerDTO dto) {
        
    }
}
