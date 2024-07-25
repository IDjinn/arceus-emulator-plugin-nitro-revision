package serializers.rooms.entities.components;

import habbo.rooms.entities.status.IEntityStatusComponent;
import networking.packets.IPacketSerializer;
import networking.packets.IPacketWriter;
import utils.StringBuilderHelper;

public class EntityStatusSerializer implements IPacketSerializer<IEntityStatusComponent> {
    @Override
    public void serialize(IPacketWriter writer, IEntityStatusComponent statusComponent) {
        final var entityStatus = StringBuilderHelper.getBuilder().append('/');
        for (var bucket : statusComponent.getStatus().values()) {
            entityStatus.append(bucket.getStatus().toString());
            entityStatus.append(' ');
            if (bucket.getValue() != null)
                entityStatus.append(bucket.getValue());
            entityStatus.append('/');
        }

        writer.appendString(entityStatus.toString());
    }
}
