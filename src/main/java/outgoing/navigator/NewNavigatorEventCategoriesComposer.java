package outgoing.navigator;

import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.navigator.NewNavigatorEventCategoriesComposerDTO;
import packets.outgoing.navigator.INewNavigatorEventCategoriesComposer;


public class NewNavigatorEventCategoriesComposer implements  INewNavigatorEventCategoriesComposer {
    @Override
    public void compose(IPacketWriter writer, NewNavigatorEventCategoriesComposerDTO dto) {
        writer.appendInt(dto.categories().size());
        for (final var category : dto.categories()) {
            writer.appendInt(category.getId());
            writer.appendString(category.getName());
            writer.appendBoolean(category.isVisible());
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.NewNavigatorEventCategoriesComposer;
    }
}
