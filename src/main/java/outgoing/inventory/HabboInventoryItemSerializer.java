package outgoing.inventory;

import habbo.furniture.FurnitureType;
import habbo.habbos.inventory.IHabboInventoryItem;
import networking.packets.IPacketSerializer;
import networking.packets.IPacketWriter;
import packets.outgoing.inventory.IHabboInventoryItemSerializer;

public class HabboInventoryItemSerializer implements IHabboInventoryItemSerializer {
    @Override
    public void serialize(IPacketWriter writer, IHabboInventoryItem dto) {
        writer.appendInt(dto.getId())
                .appendString(dto.getFurniture().getType().toString())
                .appendInt(dto.getId(), "_ref")
                .appendInt(dto.getFurniture().getSpriteId())
                .appendInt(1, "category"); // TODO THIS, USED TO SELECTOR WIREDS

        dto.getExtraData().serialize(writer);

        writer.appendBoolean(false, "_isRecyclable") // TODO 
                .appendBoolean(true, "_tradable")
                .appendBoolean(!dto.getExtraData().getLimitedData().isLimited(), "_isGroupable (inventory stack?)")
                .appendBoolean(false, "_sellable")

                .appendInt(-1, "_secondsToExpiration")
                .appendBoolean(false, "_hasRentPeriodStarted")
                .appendInt(-1, "_flatId"); // TODO

        if (dto.getFurniture().getType().equals(FurnitureType.FLOOR)) {
            writer.appendString("", "_slotId");
            writer.appendInt(-1, "_extra");
        }
    }
}
