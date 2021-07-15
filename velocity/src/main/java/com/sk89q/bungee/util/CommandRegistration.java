package com.sk89q.bungee.util;

import java.util.List;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.CommandManager;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandsManager;

public class CommandRegistration {
    public CommandRegistration(Object plugin, CommandManager commandManager, CommandsManager<?> commands, CommandExecutor<CommandSource> executor) {
        this.plugin = plugin;
        this.commandManager = commandManager;
        this.commands = commands;
        this.executor = executor;
    }

    public boolean register(Class<?> clazz) {
        return this.registerAll(this.commands.registerAndReturn(clazz));
    }

    public boolean registerAll(List<Command> registered) {
        for(Command command : registered) {
            String[] otherAliases = new String[command.aliases().length - 1];
            System.arraycopy(command.aliases(), 1, otherAliases, 0, otherAliases.length);
            CommandWrapper wrapper = new CommandWrapper(this.executor, command.aliases()[0], command.aliases());
            this.commandManager.register(command.aliases()[0], wrapper, otherAliases);
        }
        return true;
    }

    private final Object plugin;
    private final CommandManager commandManager;
    private final CommandsManager<?> commands;
    private final CommandExecutor<CommandSource> executor;
}
