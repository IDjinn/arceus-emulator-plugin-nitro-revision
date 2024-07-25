package outgoing.session.logindata;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.session.logindata.IUserAchievementScoreComposer;


public class UserAchievementScoreComposer implements  IUserAchievementScoreComposer {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendInt(100);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserAchievementScoreComposer;
    }
}
