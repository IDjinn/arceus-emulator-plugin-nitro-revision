package outgoing.rooms.entities.chat;

import habbo.commands.ICommand;
import habbo.internationalization.IInternationalizationManager;
import networking.packets.IOutgoingPacket;

import java.util.List;
import java.util.Locale;

public class CommandListComposer extends IOutgoingPacket<U> {
    public CommandListComposer(final List<? extends ICommand> commandList,
                               final IInternationalizationManager internationalizationManager,
                               final Locale locale) {
        super(1234);

        this.appendInt(commandList.size());
        for (final var command : commandList) {
            serialize(this, internationalizationManager, locale, command);
        }
    }

    public static void serialize(
            final IOutgoingPacket<U> packet,
            final IInternationalizationManager internationalizationManager,
            final Locale locale,
            final ICommand command
    ) {
        packet.appendString(internationalizationManager.getLocalizedString(command.getName(), locale));
        packet.appendString(internationalizationManager.getLocalizedString(command.getDescription(), locale));
        packet.appendInt(command.getAlias().length);
        for (final var alias : command.getAlias()) {
            packet.appendString(alias);
        }
        packet.appendInt(command.getParameters().size());
        for (final var parameter : command.getParameters()) {
            parameter.serializeParameter(packet);
        }
    }
}
