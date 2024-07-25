package incoming;

import com.google.inject.Provider;
import networking.packets.IIncomingEvent;
import org.reflections.Reflections;
import packets.PacketManager;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IncomingEventAsListProvider implements Provider<List<Class<? extends IIncomingEvent>>> {
    private final Reflections reflections = new Reflections(PacketManager.class.getPackage().getName());

    @Override
    public List<Class<? extends IIncomingEvent>> get() {
        List<Class<? extends IIncomingEvent>> eventClasses = new ArrayList<>();
        Set<Class<? extends IIncomingEvent>> subTypes = this.reflections.getSubTypesOf(IncomingEvent.class);

        for (Class<? extends IIncomingEvent> clazz : subTypes) {
            if (!Modifier.isAbstract(clazz.getModifiers())) {
                eventClasses.add(clazz);
            }
        }

        return eventClasses;
    }
}
