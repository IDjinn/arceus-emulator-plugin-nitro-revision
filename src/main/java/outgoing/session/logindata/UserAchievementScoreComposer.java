package outgoing.session.logindata;

import networking.packets.OutgoingPacket;
import networking.packets.PacketDTO;
import networking.packets.PacketWriter;
import outgoing.OutgoingHeaders;


public class UserAchievementScoreComposer implements OutgoingPacket<PacketDTO> {
    @Override
    public void compose(PacketWriter writer, PacketDTO dto) {
        writer.appendInt(100);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserAchievementScoreComposer;
    }
}
