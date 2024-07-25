package outgoing.navigator;

import habbo.habbos.data.navigator.IHabboNavigatorWindowSettings;
import networking.packets.outgoing.IOutgoingDTOSerializer;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.navigator.INewNavigatorSettingsComposer;


public class NewNavigatorSettingsComposer implements IOutgoingDTOSerializer<IHabboNavigatorWindowSettings>, INewNavigatorSettingsComposer {
    @Override
    public void compose(IPacketWriter writer, IHabboNavigatorWindowSettings settings) {
        writer.appendInt(settings.getWindowX());
        writer.appendInt(settings.getWindowY());
        writer.appendInt(settings.getWindowWidth());
        writer.appendInt(settings.getWindowHeight());
        writer.appendBoolean(settings.isLeftPanelCollapsed());
        writer.appendInt(settings.getResultsMode());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.NewNavigatorSettingsComposer;
    }
}
