package outgoing.navigator;

import networking.packets.IOutgoingPacket;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.navigator.NewNavigatorEventCategoriesComposerDTO;


public class NewNavigatorEventCategoriesComposer implements IOutgoingPacket<NewNavigatorEventCategoriesComposerDTO> {
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
