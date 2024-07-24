package outgoing.achievements;

import networking.packets.IPacketWriter;
import networking.packets.OutgoingPacket;
import networking.packets.IPacketDTO;
import outgoing.OutgoingHeaders;


public class AchievementListComposer implements OutgoingPacket<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendInt(0);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.AchievementListComposer;
    }
}
