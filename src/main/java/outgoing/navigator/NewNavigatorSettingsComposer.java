package outgoing.navigator;

import habbo.habbos.data.navigator.IHabboNavigatorWindowSettings;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.navigator.NewNavigatorSettingsComposerDTO;
import packets.outgoing.navigator.INewNavigatorSettingsComposer;


public class NewNavigatorSettingsComposer implements  INewNavigatorSettingsComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.NewNavigatorSettingsComposer;
    }

    @Override
    public void compose(IPacketWriter writer, NewNavigatorSettingsComposerDTO settings) {
        writer.appendInt(settings.windowX());
        writer.appendInt(settings.windowY());
        writer.appendInt(settings.windowWidth());
        writer.appendInt(settings.windowHeight());
        writer.appendBoolean(settings.isLeftPanelCollapsed());
        writer.appendInt(settings.resultsMode());
    }
}
