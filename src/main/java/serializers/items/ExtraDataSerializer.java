package serializers.items;

import habbo.furniture.extra.data.IExtraData;
import networking.packets.IPacketSerializer;
import networking.packets.IPacketWriter;

public class ExtraDataSerializer implements IPacketSerializer<IExtraData> {
    @Override
    public void serialize(IPacketWriter writer, IExtraData dto) {
        writer.appendInt(dto.getExtraDataType().getType() | (dto.getLimitedData().isLimited() ? dto.LTD_FLAG : 0));
        this.serializeValue(writer, dto);
        if (dto.getLimitedData().isLimited()) {
            writer.appendInt(dto.getLimitedData().limitedRare())
                    .appendInt(dto.getLimitedData().limitedRareTotal());
        }
    }

    private void serializeValue(IPacketWriter writer, IExtraData dto) {
        
    }
}
