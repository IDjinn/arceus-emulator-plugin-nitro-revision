package outgoing.badges;

import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.badges.UserBadgesDTO;
import packets.outgoing.badges.IUserBadgesComposer;

public class UserBadgesComposer implements IOutgoingDTOSerializer<UserBadgesDTO>, IUserBadgesComposer {
    @Override
    public void compose(IPacketWriter writer, UserBadgesDTO dto) {
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
