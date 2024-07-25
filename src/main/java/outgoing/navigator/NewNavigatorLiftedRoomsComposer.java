package outgoing.navigator;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.navigator.INewNavigatorLiftedRoomsComposer;


public class NewNavigatorLiftedRoomsComposer implements  INewNavigatorLiftedRoomsComposer {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendInt(0);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.NewNavigatorLiftedRoomsComposer;
    }
}
