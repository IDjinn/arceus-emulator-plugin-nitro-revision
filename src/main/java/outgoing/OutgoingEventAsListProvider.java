package outgoing;

import com.google.inject.Provider;
import networking.packets.outgoing.IOutgoingEvent;
import org.reflections.Reflections;
import packets.PacketManager;

import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class OutgoingEventAsListProvider implements Provider<ArrayList<Class<? extends IOutgoingEvent>>> {
    private final Reflections reflections = new Reflections(PacketManager.class.getPackage().getName());

    @Override
    public ArrayList<Class<? extends IOutgoingEvent>> get() {
        final var eventClasses = new ArrayList<Class<? extends IOutgoingEvent>>();
        final var subTypes = this.reflections.getSubTypesOf(IOutgoingEvent.class);

        for (final var clazz : subTypes) {
            if (!Modifier.isAbstract(clazz.getModifiers())) {
                eventClasses.add(clazz);
            }
        }

        return eventClasses;
    }
}
