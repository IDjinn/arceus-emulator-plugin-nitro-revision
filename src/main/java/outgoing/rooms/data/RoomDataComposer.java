package outgoing.rooms.data;

import com.google.inject.Inject;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.room.data.RoomDataComposerDTO;
import packets.outgoing.rooms.data.IRoomDataComposer;
import serializers.rooms.RoomSerializer;


public class RoomDataComposer implements  IRoomDataComposer {
    private @Inject RoomSerializer roomSerializer;
    @Override
    public void compose(IPacketWriter writer, RoomDataComposerDTO dto) {
        this.roomSerializer.serialize(writer, dto.room());

        writer.appendBoolean(dto.roomForward());
        writer.appendBoolean(dto.room().getData().isStaffPicked());
        writer.appendBoolean(false); // TODO: Check if habbo is member of room guild
        writer.appendBoolean(false); // TODO: is muted

        writer.appendInt(dto.room().getData().getWhoCanMute());
        writer.appendInt(dto.room().getData().getWhoCanKick());
        writer.appendInt(dto.room().getData().getWhoCanBan());

        writer.appendBoolean(false); // TODO: Permissions: mute all button

        writer.appendInt(dto.room().getData().getChatMode());
        writer.appendInt(dto.room().getData().getChatWeight());
        writer.appendInt(dto.room().getData().getChatSpeed());
        writer.appendInt(dto.room().getData().getChatDistance());
        writer.appendInt(dto.room().getData().getChatProtection());
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.RoomDataComposer;
    }
}
