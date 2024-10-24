package outgoing;

import com.google.inject.AbstractModule;
import networking.packets.outgoing.IOutgoingEvent;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;

public class AutoBindOutgoingEventsModule extends AbstractModule {
    @SuppressWarnings("unchecked")
    @Override
    protected void configure() {
        Reflections reflections = new Reflections(AutoBindOutgoingEventsModule.class.getPackage().getName());
        for (final var clazz : reflections.getSubTypesOf(IOutgoingEvent.class)) {
            if (Modifier.isAbstract(clazz.getModifiers())) continue;
            this.bind((Class<? extends IOutgoingEvent<?>>) clazz).asEagerSingleton();
        }
    }
}