package outgoing.session.logindata;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.logindata.UserPerksComposerDTO;
import packets.outgoing.session.logindata.IUserPerksComposer;


public class UserPerksComposer implements  IUserPerksComposer {
    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserPerksComposer;
    }

    @Override
    public void compose(IPacketWriter writer, UserPerksComposerDTO dto) {
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
}
