package outgoing.badges;

import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.badges.UserBadgesComposerDTO;
import packets.outgoing.badges.IUserBadgesComposer;

public class UserBadgesComposer implements IUserBadgesComposer {
    @Override
    public void compose(IPacketWriter writer, UserBadgesComposerDTO dto) {
        writer.appendInt(dto.userId());
        for (final var entry : dto.badges().entrySet()) {
            final var slot = entry.getKey();
            final var code = entry.getValue();
            writer.appendInt(slot);
            writer.appendString(code);
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserBadgesComposer;
    }
}
