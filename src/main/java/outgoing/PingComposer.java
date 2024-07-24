package outgoing;


import networking.packets.OutgoingPacket;
import networking.packets.PacketDTO;
import networking.packets.PacketWriter;

public class PingComposer implements OutgoingPacket<PacketDTO> {
    @Override
    public void compose(PacketWriter writer, PacketDTO dto) {
        
    }

    @Override
    public int getHeaderId() {
        return 3928;
    }
}
