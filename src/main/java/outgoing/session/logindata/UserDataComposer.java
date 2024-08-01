package outgoing.session.logindata;

import networking.packets.IPacketWriter;
import outgoing.OutgoingHeaders;
import packets.dto.outgoing.session.logindata.UserDataComposerDTO;
import packets.outgoing.session.logindata.IUserDataComposer;


public class UserDataComposer implements  IUserDataComposer {
    @Override
    public void encode(final IPacketWriter writer, final UserDataComposerDTO dto) {
        final var habbo = dto.habbo();

        writer.appendInt(habbo.getData().getId());
        writer.appendString(habbo.getData().getUsername());
        writer.appendString(habbo.getData().getLook());
        writer.appendString(habbo.getData().getGender());
        writer.appendString(habbo.getData().getMotto());
        writer.appendString(habbo.getData().getUsername());
        writer.appendBoolean(false);
        writer.appendInt(habbo.getSettings().getRespectPointsReceived());
        writer.appendInt(habbo.getSettings().getRespectPointsGiven());
        writer.appendInt(habbo.getSettings().getPetRespectPointsToGive());
        writer.appendBoolean(false);
        writer.appendString("01-01-1970 00:00:00");
        writer.appendBoolean(habbo.getSettings().allowNameChange());
        writer.appendBoolean(false);
    }

    @Override
    public int getHeaderId() {
        return OutgoingHeaders.UserDataComposer;
    }

}
