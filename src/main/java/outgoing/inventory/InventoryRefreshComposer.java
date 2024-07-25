package outgoing.inventory;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.inventory.IInventoryRefreshComposer;


public class InventoryRefreshComposer implements  IInventoryRefreshComposer {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.InventoryRefreshComposer;
    }
}
