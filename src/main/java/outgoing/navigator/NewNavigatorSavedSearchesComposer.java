package outgoing.navigator;

import networking.packets.IPacketWriter;
import networking.packets.IOutgoingPacket;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.navigator.NewNavigatorSavedSearchesComposerDTO;

public class NewNavigatorSavedSearchesComposer implements IOutgoingPacket<NewNavigatorSavedSearchesComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, NewNavigatorSavedSearchesComposerDTO dto) {
        writer.appendInt(dto.searches().size());
        for (final var search : dto.searches()) {
            writer.appendInt(search.getId());
            writer.appendString(search.getSearchCode());
            writer.appendString(search.getFilter());
            writer.appendString("");
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.NewNavigatorSavedSearchesComposer;
    }
}
