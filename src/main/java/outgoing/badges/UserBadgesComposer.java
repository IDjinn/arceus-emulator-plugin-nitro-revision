package outgoing.badges;

import networking.packets.IPacketWriter;
import networking.packets.OutgoingPacket;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.badges.UserBadgesDTO;

public class UserBadgesComposer implements OutgoingPacket<UserBadgesDTO> {
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
