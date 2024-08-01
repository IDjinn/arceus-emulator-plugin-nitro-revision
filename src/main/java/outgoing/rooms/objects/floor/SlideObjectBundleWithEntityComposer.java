package outgoing.rooms.objects.floor;

import com.google.inject.Inject;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.rooms.objects.floor.ISlideObjectBundleWithEntityComposer;
import packets.outgoing.rooms.objects.floor.slide.EntitySlideObjectBundleDTO;
import serializers.items.SlideObjectSerializer;

public class SlideObjectBundleWithEntityComposer implements ISlideObjectBundleWithEntityComposer {
    private @Inject SlideObjectSerializer slideObjectSerializer;
    @Override
    public void encode(IPacketWriter writer, EntitySlideObjectBundleDTO dto) {
        this.slideObjectSerializer.serialize(writer, dto);

        writer.appendInt(dto.movementType().ordinal());
        writer.appendInt(dto.entityEntry().virutalId());
        writer.appendString(String.valueOf(dto.oldPosition().getZ()));
        writer.appendString(String.valueOf(dto.newPosition().getZ()));
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.SlideObjectBundleMessageComposer;
    }
}
