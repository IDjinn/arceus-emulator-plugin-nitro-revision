package outgoing.purse;

import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.purse.UserCurrencyComposerDTO;
import packets.outgoing.purse.IUserCurrencyComposer;


public class UserCurrencyComposer implements  IUserCurrencyComposer {
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
