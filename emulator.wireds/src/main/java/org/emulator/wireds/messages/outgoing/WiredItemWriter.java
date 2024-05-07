package org.emulator.wireds.messages.outgoing;

import networking.packets.OutgoingPacket;
import org.emulator.wireds.boxes.WiredItem;
import org.emulator.wireds.boxes.util.WiredSelectionType;

public final class WiredItemWriter {
    public static void serialize(final OutgoingPacket packet, final WiredItem wiredItem) {
        packet.appendInt(wiredItem.getId());
        packet.appendInt(wiredItem.getInterface());

        // INPUT CONFIGURATIONS
        {
            packet.appendInt(wiredItem.getWiredItemSourceType().ordinal());
            packet.appendInt(wiredItem.getWiredEntitiesSourceType().ordinal());
            packet.appendInt(wiredItem.getWiredVariableContextType().ordinal());
            packet.appendInt(WiredSelectionType.pack(wiredItem.getSelectionType()));
        }

        // VARIABLES
        {
            wiredItem.serializeCommonVariables(packet);
            packet.appendInt(wiredItem.getInputContextVariables().size());
            for (final var variable : wiredItem.getInputContextVariables().values()) {
                variable.serialize(packet);
            }

            packet.appendInt(wiredItem.getOutputContextVariables().size());
            for (final var variable : wiredItem.getOutputContextVariables().values()) {
                variable.serialize(packet);
            }
        }

        wiredItem.getWiredData().serialize(packet);

        packet.appendInt(wiredItem.getMaxSelectionCount());
        // SELECTED ITEMS
        {
            packet.appendInt(wiredItem.getSelectedItems().size());
            for (var selectedItem : wiredItem.getSelectedItems().keySet()) {
                packet.appendInt(selectedItem);
            }
        }

        wiredItem.serializeWiredExtraStuff(packet);
    }
}
