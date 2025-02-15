package incoming.guest;

import com.google.inject.Singleton;
import io.netty.channel.ChannelHandlerContext;
import networking.packets.incoming.IIncomingPacket;
import incoming.IncomingEvent;
import networking.util.GameNetowrkingAttributes;
import networking.util.NoAuth;
import networking.util.ReleaseVersion;
import incoming.IncomingHeaders;

@Singleton
@NoAuth
public class ReleaseVersionEvent extends IncomingEvent {
    @Override
    public int getHeaderId() {
        return IncomingHeaders.ReleaseVersionEvent;
    }

    @Override
    public void parseForGuest(IIncomingPacket packet, ChannelHandlerContext ctx) {
        var production = packet.readString();
        var type = packet.readString();
        var platform = packet.readInt();
        var category = packet.readInt();

        ctx.attr(GameNetowrkingAttributes.RELEASE_VERSION).set(new ReleaseVersion(production, type, platform, category));
    }
}
