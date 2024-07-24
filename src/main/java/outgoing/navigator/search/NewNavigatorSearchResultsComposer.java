package outgoing.navigator.search;

import habbo.navigator.data.INavigatorResultCategory;
import networking.packets.IPacketWriter;
import networking.packets.IOutgoingPacket;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.navigator.NewNavigatorSearchResultsComposerDTO;

public class NewNavigatorSearchResultsComposer implements IOutgoingPacket<NewNavigatorSearchResultsComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, NewNavigatorSearchResultsComposerDTO dto) {
        writer.appendString(dto.code());
        writer.appendString(dto.query());
        
        writer.appendInt(dto.categories().size());
        for (final INavigatorResultCategory category : dto.categories()) {
            category.write(this);
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.NewNavigatorSearchResultsComposer;
    }
}
