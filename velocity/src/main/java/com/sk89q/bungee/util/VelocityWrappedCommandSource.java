package com.sk89q.bungee.util;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.proxy.Player;
import net.kyori.adventure.text.Component;
import com.sk89q.minecraft.util.commands.WrappedCommandSender;

public class VelocityWrappedCommandSource implements WrappedCommandSender {
    public VelocityWrappedCommandSource(CommandSource wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String getName() {
        if (wrapped instanceof Player)
            return ((Player) this.wrapped).getUsername();
        return "CONSOLE";
    }

    @Override
    public void sendMessage(String message) {
        this.wrapped.sendMessage(Component.text(message));
    }

    @Override
    public void sendMessage(String[] messages) {
        for (String message : messages)
            this.sendMessage(message);
    }

    @Override
    public boolean hasPermission(String permission) {
        return this.wrapped.hasPermission(permission);
    }

    @Override
    public Type getType() {
        if (this.wrapped instanceof Player) {
            return Type.PLAYER;
        } else {
            return Type.CONSOLE;
        }
    }

    @Override
    public Object getCommandSender() {
        return this.wrapped;
    }

    private final CommandSource wrapped;
}
