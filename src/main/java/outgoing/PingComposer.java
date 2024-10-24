package outgoing;


import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import networking.packets.outgoing.IOutgoingEvent;
import packets.dto.outgoing.session.PingComposerDTO;
import packets.outgoing.session.IPingComposer;

public class PingComposer implements IPingComposer {

    @Override
    public int getHeaderId() {
        return 3928;
    }

    @Override
    public void encode(IPacketWriter writer, PingComposerDTO dto) {
        
    }
}
