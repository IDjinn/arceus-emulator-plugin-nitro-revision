package incoming.navigator;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import habbo.navigator.INavigatorManager;
import networking.client.IClient;
import networking.packets.incoming.IIncomingPacket;
import incoming.IncomingEvent;
import packets.incoming.IncomingHeaders;

@Singleton
public class RequestNewNavigatorDataEvent extends IncomingEvent {
    @Inject
    private INavigatorManager navigatorManager;

    @Override
    public int getHeaderId() {
        return IncomingHeaders.RequestNewNavigatorDataEvent;
    }

    @Override
    public void parse(IIncomingPacket packet, IClient client) {
        client.sendMessages(
                new NewNavigatorSettingsComposer(client.getHabbo().getNavigator().getNavigatorWindowSettings()),
                new NewNavigatorMetaDataComposer(client.getHabbo().getNavigator()),
                new NewNavigatorLiftedRoomsComposer(),
                new NewNavigatorCollapsedCategoriesComposer(),
                new NewNavigatorEventCategoriesComposer(this.navigatorManager)
        );
    }
}
