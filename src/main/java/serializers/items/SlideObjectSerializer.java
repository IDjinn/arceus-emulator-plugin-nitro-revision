package serializers.items;

import networking.packets.IPacketSerializer;
import networking.packets.IPacketWriter;
import packets.outgoing.rooms.objects.floor.slide.SlideObjectBundleDTO;
import packets.outgoing.rooms.objects.floor.slide.SlideObjectEntry;

public class SlideObjectSerializer implements IPacketSerializer<SlideObjectBundleDTO> {
    @Override
    public void serialize(IPacketWriter writer, SlideObjectBundleDTO dto) {
        writer.appendInt(dto.oldPosition().getX());
        writer.appendInt(dto.oldPosition().getY());

        writer.appendInt(dto.newPosition().getX());
        writer.appendInt(dto.newPosition().getY());

        writer.appendList(dto.objects(), ((packetWriter, object) -> {
            packetWriter.appendInt(object.virutalId());
            packetWriter.appendString(String.valueOf(object.oldPosition().getZ()));
            packetWriter.appendString(String.valueOf(object.newPosition().getZ()));
        }));
        writer.appendInt(dto.rollerId());
    }
}
