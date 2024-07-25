package outgoing;

import com.google.inject.AbstractModule;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;

public class AutoBindOutgoingEventsModule extends AbstractModule {
    @SuppressWarnings("unchecked")
    @Override
    protected void configure() {
        Reflections reflections = new Reflections(AutoBindOutgoingEventsModule.class.getPackage().getName());
        for (final var clazz : reflections.getSubTypesOf(IOutgoingDTOSerializer.class)) {
            if (Modifier.isAbstract(clazz.getModifiers())) continue;
            this.bind((Class<? extends IOutgoingDTOSerializer<?>>) clazz).asEagerSingleton();
        }
    }
}