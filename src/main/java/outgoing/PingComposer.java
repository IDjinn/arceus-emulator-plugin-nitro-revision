package outgoing;


import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;

public class PingComposer implements IOutgoingDTOSerializer<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        
    }

    @Override
    public int getHeaderId() {
        return 3928;
    }
}
