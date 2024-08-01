package outgoing.session.rooms;

import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.rooms.FavoriteRoomsCountComposerDTO;
import packets.outgoing.session.rooms.IFavoriteRoomsCountComposer;


public class FavoriteRoomsCountComposer implements IFavoriteRoomsCountComposer {
    @Override
    public void encode(IPacketWriter writer, FavoriteRoomsCountComposerDTO dto) {
        writer.appendInt(30);
        writer.appendInt(0);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.FavoriteRoomsCountComposer;
    }
}
