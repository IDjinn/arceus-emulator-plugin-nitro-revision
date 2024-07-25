package outgoing.navigator;

import habbo.habbos.data.navigator.IHabboNavigatorSearch;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.navigator.NewNavigatorMetaDataComposerDTO;
import packets.outgoing.navigator.INewNavigatorMetaDataComposer;

public class NewNavigatorMetaDataComposer implements  INewNavigatorMetaDataComposer {
    @Override
    public void compose(IPacketWriter writer, NewNavigatorMetaDataComposerDTO dto) {
        writer.appendInt(NewNavigatorMetaDataComposerDTO.tabs.length);
        for (String tabName : NewNavigatorMetaDataComposerDTO.tabs) {
            writer.appendString(tabName);

            writer.appendInt(dto.savedSearches().size());
            for (final IHabboNavigatorSearch search : dto.savedSearches()) {
                search.write(this);
            }
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.NewNavigatorMetaDataComposer;
    }
}
