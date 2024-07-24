package outgoing.navigator;

import networking.packets.IPacketDTO;
import networking.packets.IPacketWriter;
import networking.packets.IOutgoingPacket;
import outgoing.OutgoingHeaders;


public class NewNavigatorCollapsedCategoriesComposer implements IOutgoingPacket<IPacketDTO> {
    @Override
    public void compose(IPacketWriter writer, IPacketDTO dto) {
        writer.appendInt(46);

        writer.appendString("new_ads");
        writer.appendString("friend_finding");
        writer.appendString("staffpicks");
        writer.appendString("with_friends");
        writer.appendString("with_rights");
        writer.appendString("query");
        writer.appendString("recommended");
        writer.appendString("my_groups");
        writer.appendString("favorites");
        writer.appendString("history");
        writer.appendString("top_promotions");
        writer.appendString("campaign_target");
        writer.appendString("friends_rooms");
        writer.appendString("groups");
        writer.appendString("metadata");
        writer.appendString("history_freq");
        writer.appendString("highest_score");
        writer.appendString("competition");
        writer.appendString("category__Agencies");
        writer.appendString("category__Role Playing");
        writer.appendString("category__Global Chat & Discussi");
        writer.appendString("category__GLOBAL BUILDING AND DE");
        writer.appendString("category__global party");
        writer.appendString("category__global games");
        writer.appendString("category__global fansite");
        writer.appendString("category__global help");
        writer.appendString("category__Trading");
        writer.appendString("category__global personal space");
        writer.appendString("category__Habbo Life");
        writer.appendString("category__TRADING");
        writer.appendString("category__global official");
        writer.appendString("category__global trade");
        writer.appendString("category__global reviews");
        writer.appendString("category__global bc");
        writer.appendString("category__global personal space");
        writer.appendString("eventcategory__Hottest Events");
        writer.appendString("eventcategory__Parties & Music");
        writer.appendString("eventcategory__Role Play");
        writer.appendString("eventcategory__Help Desk");
        writer.appendString("eventcategory__Trading");
        writer.appendString("eventcategory__Games");
        writer.appendString("eventcategory__Debates & Discuss");
        writer.appendString("eventcategory__Grand Openings");
        writer.appendString("eventcategory__Friending");
        writer.appendString("eventcategory__Jobs");
        writer.appendString("eventcategory__Group Events");
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.NewNavigatorCollapsedCategoriesComposer;
    }
}
