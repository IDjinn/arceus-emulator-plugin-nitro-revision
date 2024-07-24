package outgoing;


import networking.packets.IPacketWriter;
import networking.packets.OutgoingPacket;
import networking.packets.IPacketDTO;

public class PingComposer implements OutgoingPacket<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        
    }

    @Override
    public int getHeaderId() {
        return 3928;
    }
}
