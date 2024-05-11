package org.emulator.wireds.boxes.variables;

import habbo.variables.IVariable;
import habbo.variables.Variable;
import networking.packets.IIncomingPacket;
import networking.packets.OutgoingPacket;
import org.emulator.wireds.boxes.util.WiredVariableContextType;
import org.jetbrains.annotations.Nullable;

public class WiredVariable extends Variable implements IVariable {
    private WiredVariableContextType contextType;
    private @Nullable String alias;
    private @Nullable String defaultValue;

    public WiredVariable(final String key, final String value, final String alias, final String defaultValue,
                         final WiredVariableContextType wiredVariableContextType) {
        super(key, value);
        this.contextType = wiredVariableContextType;
        this.alias = alias;
        this.defaultValue = defaultValue;
    }

    public WiredVariable(final WiredVariableContextType wiredVariableContextType, final String key,
                         final String value) {
        this(key, value, "", "", wiredVariableContextType);
    }

    public static WiredVariable fromPacket(final IIncomingPacket packet) {
        final String key = packet.readString();
        final String value = packet.readString();
        final WiredVariableContextType contextType = WiredVariableContextType.fromLabel(packet.readString());
        final String alias = packet.readString();
        final String defaultValue = packet.readString();
        return new WiredVariable(key, value, defaultValue, alias, contextType);
    }

    @Override
    public void serialize(final OutgoingPacket packet) {
        super.serialize(packet);
        packet.appendString(this.getContextType().getType());
        packet.appendString(this.getContextType().getKey() != null ? this.getContextType().getKey() : "");
        packet.appendString(this.getAlias() != null ? this.getAlias() : "");
        packet.appendString(this.getDefaultValue() != null ? this.getDefaultValue() : "");
    }

    public WiredVariableContextType getContextType() {
        return this.contextType;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(final String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(final String alias) {
        this.alias = alias;
    }
}