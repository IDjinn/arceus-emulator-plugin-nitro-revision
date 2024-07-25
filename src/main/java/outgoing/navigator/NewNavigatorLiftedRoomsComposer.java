package outgoing.navigator;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.navigator.NewNavigatorLiftedRoomsComposerDTO;
import packets.outgoing.navigator.INewNavigatorLiftedRoomsComposer;


public class NewNavigatorLiftedRoomsComposer implements  INewNavigatorLiftedRoomsComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.NewNavigatorLiftedRoomsComposer;
    }

    @Override
    public void compose(IPacketWriter writer, NewNavigatorLiftedRoomsComposerDTO dto) {
        writer.appendInt(0);
    }
}
