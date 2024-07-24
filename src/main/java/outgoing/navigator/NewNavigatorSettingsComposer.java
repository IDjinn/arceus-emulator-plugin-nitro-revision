package outgoing.navigator;

import habbo.habbos.data.navigator.IHabboNavigatorWindowSettings;
import networking.packets.IPacketWriter;
import networking.packets.OutgoingPacket;
import outgoing.OutgoingHeaders;


public class NewNavigatorSettingsComposer implements OutgoingPacket<IHabboNavigatorWindowSettings> {
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
