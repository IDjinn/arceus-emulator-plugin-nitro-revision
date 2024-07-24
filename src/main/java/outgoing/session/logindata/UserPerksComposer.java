package outgoing.session.logindata;

import habbo.habbos.IHabbo;
import networking.packets.OutgoingPacket;
import networking.packets.PacketDTO;
import networking.packets.PacketWriter;
import outgoing.OutgoingHeaders;


public class UserPerksComposer implements OutgoingPacket<PacketDTO> {
    @Override
    public void compose(PacketWriter writer, PacketDTO dto) {
        writer.appendInt(15);

        writer.appendString("USE_GUIDE_TOOL");
        writer.appendString("requirement.unfulfilled.helper_level_4");
        writer.appendBoolean(false);

        writer.appendString("GIVE_GUIDE_TOURS");
        writer.appendString("");
        writer.appendBoolean(false);

        writer.appendString("JUDGE_CHAT_REVIEWS");
        writer.appendString("requirement.unfulfilled.helper_level_6");
        writer.appendBoolean(false);

        writer.appendString("VOTE_IN_COMPETITIONS");
        writer.appendString("requirement.unfulfilled.helper_level_2");
        writer.appendBoolean(true);

        writer.appendString("CALL_ON_HELPERS");
        writer.appendString("");
        writer.appendBoolean(true);

        writer.appendString("CITIZEN");
        writer.appendString("");
        writer.appendBoolean(true);

        writer.appendString("TRADE");
        writer.appendString("requirement.unfulfilled.no_trade_lock");
        writer.appendBoolean(true);

        writer.appendString("HEIGHTMAP_EDITOR_BETA");
        writer.appendString("requirement.unfulfilled.feature_disabled");
        writer.appendBoolean(true);

        writer.appendString("BUILDER_AT_WORK");
        writer.appendString("");
        writer.appendBoolean(true);

        writer.appendString("CALL_ON_HELPERS");
        writer.appendString("");
        writer.appendBoolean(true);

        writer.appendString("CAMERA");
        writer.appendString("");
        writer.appendBoolean(true);

        writer.appendString("NAVIGATOR_PHASE_TWO_2014");
        writer.appendString("");
        writer.appendBoolean(true);

        writer.appendString("MOUSE_ZOOM");
        writer.appendString("");
        writer.appendBoolean(true);

        writer.appendString("NAVIGATOR_ROOM_THUMBNAIL_CAMERA");
        writer.appendString("");
        writer.appendBoolean(true);

        writer.appendString("HABBO_CLUB_OFFER_BETA");
        writer.appendString("");
        writer.appendBoolean(true);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserPerksComposer;
    }
}
