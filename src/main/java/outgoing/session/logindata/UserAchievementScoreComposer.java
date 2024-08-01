package outgoing.session.logindata;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.logindata.UserAchievementScoreComposerDTO;
import packets.outgoing.session.logindata.IUserAchievementScoreComposer;


public class UserAchievementScoreComposer implements  IUserAchievementScoreComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserAchievementScoreComposer;
    }

    @Override
    public void encode(IPacketWriter writer, UserAchievementScoreComposerDTO dto) {
        writer.appendInt(100);
    }
}
