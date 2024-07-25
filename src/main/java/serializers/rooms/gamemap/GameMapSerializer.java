package serializers.rooms.gamemap;

import habbo.rooms.components.gamemap.IRoomTile;
import networking.packets.IPacketSerializer;
import networking.packets.IPacketWriter;

public class GameMapSerializer implements IPacketSerializer<IRoomTile> {
    private static final int STACKING_BLOCKED_FLAG = 0x4000;
    private static final int ENCODE_HEIGHT_FLAG = 0x0100;
    private static final int HEIGHT_FLAG = 0x4000;

    private int encodeTileHeight(double height) {
        return (int) (height * ENCODE_HEIGHT_FLAG);
    }

    @Override
    public void serialize(IPacketWriter writer, IRoomTile tile) {
        final var relativeMapHeight = tile.getRelativeMapHeight();
        if (relativeMapHeight.isPresent()) {
            writer.appendShort(encodeTileHeight(relativeMapHeight.get()));
        } else {
            writer.appendShort(tile.getZ() | STACKING_BLOCKED_FLAG);
        }
    }
}