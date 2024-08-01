package outgoing.rooms.objects.floor;

import com.google.inject.Inject;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.outgoing.rooms.objects.floor.ISlideObjectBundleMessageComposer;
import packets.outgoing.rooms.objects.floor.slide.SlideObjectBundleDTO;
import serializers.items.SlideObjectSerializer;

public class SlideObjectBundleMessageComposer implements ISlideObjectBundleMessageComposer {
    private @Inject SlideObjectSerializer slideObjectSerializer;
    @Override
    public void encode(IPacketWriter writer, SlideObjectBundleDTO dto) {
        this.slideObjectSerializer.serialize(writer, dto);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.SlideObjectBundleMessageComposer;
    }
}
