package outgoing.purse;

import networking.packets.IPacketWriter;
import networking.packets.IOutgoingPacket;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.purse.UserCurrencyComposerDTO;


public class UserCurrencyComposer implements IOutgoingPacket<UserCurrencyComposerDTO> {
    @Override
    public void compose(IPacketWriter writer, UserCurrencyComposerDTO dto) {
        writer.appendInt(dto.currencies().size());
        for (final var currency : dto.currencies()) {
            writer.appendInt(currency.getCurrencyType());
            writer.appendInt(currency.getAmount());
        }
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserCurrencyComposer;
    }
}
