package incoming;

import io.netty.channel.ChannelHandlerContext;
import networking.client.IClient;
import networking.packets.incoming.IIncomingEvent;
import networking.packets.incoming.IIncomingPacket;

public abstract class IncomingEvent implements IIncomingEvent {

    @Override
    public void parse(IIncomingPacket packet, IClient client) {
        
    }

    @Override
    public void parseForGuest(IIncomingPacket packet, ChannelHandlerContext ctx) {
        throw new RuntimeException("Should not be called by base class, it does means it was not overridden by derived class and suggested an implementation error");
    }
}
