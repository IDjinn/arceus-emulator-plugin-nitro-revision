package serializers.rooms.gamemap;

import habbo.rooms.components.gamemap.IRoomTile;
import networking.packets.IPacketWriter;

public class GameMapSerializer {
    private static final int STACKING_BLOCKED_FLAG = 0x4000;
    private static final int ENCODE_HEIGHT_FLAG = 0x0100;
    private static final int HEIGHT_FLAG = 0x4000;

    private int encodeTileHeight(double height) {
        return (int) (height * ENCODE_HEIGHT_FLAG);
    }

    public void serializeTileHeight(final IPacketWriter packet, final IRoomTile tile) {
        final var relativeMapHeight = tile.getRelativeMapHeight();
        if (relativeMapHeight.isPresent()) {
            packet.appendShort(encodeTileHeight(relativeMapHeight.get()));
        } else {
            packet.appendShort(tile.getZ() | STACKING_BLOCKED_FLAG);
        }
    }
}