package outgoing.rooms.entities.variables;

import habbo.variables.IVariable;
import networking.packets.IOutgoingPacket;

import java.util.Map;

public class EntityVariablesComposer extends IOutgoingPacket<U> {
    public EntityVariablesComposer(Map<String, IVariable<?>> variables) {
        super(OutgoingHeaders.EntityVariablesComposer);

        final var visible = variables.values().stream().filter(IVariable::isVisible).toList();
        this.appendInt(visible.size());
        for (final var variable : visible) {
            variable.serialize(this);
        }
    }
}
