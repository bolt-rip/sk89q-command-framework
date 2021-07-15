package com.sk89q.bungee.util;

import com.velocitypowered.api.command.CommandSource;

import com.sk89q.minecraft.util.commands.CommandsManager;

public class VelocityCommandsManager extends CommandsManager<CommandSource> {
    @Override
    public boolean hasPermission(CommandSource player, String perm) {
        return player.hasPermission(perm);
    }
}
