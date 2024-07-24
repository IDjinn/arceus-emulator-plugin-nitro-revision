package outgoing.catalog.pages;

import habbo.catalog.pages.ICatalogPage;
import networking.packets.IPacketSerializer;
import networking.packets.IPacketWriter;
import packets.dto.outgoing.catalog.CatalogPageComposerDTO;

import static java.lang.StringTemplate.STR;

public class CatalogPageItemsSerializer implements IPacketSerializer<CatalogPageComposerDTO> { 
    @Override
    public void serialize(IPacketWriter writer, CatalogPageComposerDTO dto) {
        writer.appendInt(dto.page().getItems().size());
        for (var item : dto.page().getItems().values()) {
            writer.appendInt(item.getId())
                    .appendString(item.getDisplayName())
                    .appendBoolean(false, "rent") //rent
                    .appendInt(item.getCostCredits())
                    .appendInt(0, "_priceActivityPoints") // TODO OTHER CURRENCY TYPE
                    .appendInt(0, "_priceActivityPointsType")
                    .appendBoolean(false, "_giftable");// TODO GIFT

            writer.appendInt(1, "bundle items?");
            {
                writer.appendString(item.getFurniture().getType().toString())
                        .appendInt(item.getFurniture().getSpriteId())
                        .appendString(item.getPresetData(), "extraData")
                        .appendInt(item.getAmount(), "itemAmount")
                        .appendBoolean(item.getLimitedTotal() > 0, "isLimited");
                if (item.getLimitedTotal() > 0) {
                    writer.appendInt(item.getLimitedTotal());
                    writer.appendInt(item.getLimitedTotal() - item.getLimitedSells());
                }
            }

            writer.appendInt(0)// TODO clubOnly
                    .appendBoolean(item.allowOffer(), "_bundlePurchaseAllowed") // TODO
                    .appendBoolean(false, "_isPet")
                    .appendString(STR."\{item.getDisplayName()}.png");
        }
    }
}
