package incoming;

import com.google.inject.AbstractModule;
import networking.packets.incoming.IIncomingEvent;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;

public class AutoBindIncomingEventsModule extends AbstractModule {
    @Override
    protected void configure() {
        Reflections reflections = new Reflections(IncomingEvent.class.getPackage().getName());
        for (final var clazz : reflections.getSubTypesOf(IncomingEvent.class)) {
            if (Modifier.isAbstract(clazz.getModifiers())) continue;
            this.bind((Class<? extends IIncomingEvent>) clazz);
        }
    }
}