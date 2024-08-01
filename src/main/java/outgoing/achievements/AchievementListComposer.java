package outgoing.achievements;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.achievemetns.AchievementListComposerDTO;
import packets.outgoing.achievements.IAchievementListComposer;


public class AchievementListComposer implements IAchievementListComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.AchievementListComposer;
    }

    @Override
    public void encode(IPacketWriter writer, AchievementListComposerDTO dto) {
        writer.appendInt(0);
    }
}
