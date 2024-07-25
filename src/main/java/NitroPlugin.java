import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import core.plugins.IPlugin;
import incoming.AutoBindIncomingEventsModule;
import incoming.IncomingEvent;
import incoming.IncomingEventAsListProvider;
import networking.packets.IIncomingEvent;
import networking.packets.IOutgoingPacket;
import org.apache.maven.artifact.versioning.ComparableVersion;
import outgoing.AutoBindOutgoingEventsModule;
import outgoing.OutgoingEventAsListProvider;

import java.util.List;

public class NitroPlugin extends AbstractModule implements IPlugin {
    public static void main(String[] args) {
        throw new IllegalCallerException("Cannot be called");
    }
    
    @Inject
    private Injector injector;
    @Override
    public String getName() {
        return NitroPlugin.class.getSimpleName();
    }

    @Override
    public String getDescription() {
        return "Nitro revision packets plugin";
    }

    @Override
    public ComparableVersion getVersion() {
        return new ComparableVersion("1.0.0");
    }

    @Override
    public String getAuthor() {
        return "IDjinn";
    }

    @Override
    public void init() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public Injector getInjector() {
        return injector;
    }
    
    @Override
    protected void configure() {
        this.bind(IIncomingEvent.class).to(IncomingEvent.class);
        
        this.install(new AutoBindIncomingEventsModule());
        this.install(new AutoBindOutgoingEventsModule());
        this.bind(new TypeLiteral<List<Class<? extends IIncomingEvent>>>() {
        }).toProvider(IncomingEventAsListProvider.class);
        this.bind(new TypeLiteral<List<Class<? extends IOutgoingPacket>>>() {
        }).toProvider(OutgoingEventAsListProvider.class);
    }
}
