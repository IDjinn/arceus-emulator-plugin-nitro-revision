package outgoing.navigator;

import habbo.navigator.data.INavigatorResultCategory;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.navigator.NewNavigatorSearchResultsComposerDTO;
import packets.outgoing.navigator.INewNavigatorSearchResultsComposer;

public class NewNavigatorSearchResultsComposer implements  INewNavigatorSearchResultsComposer {
    @Override
    public void encode(IPacketWriter writer, NewNavigatorSearchResultsComposerDTO dto) {
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
