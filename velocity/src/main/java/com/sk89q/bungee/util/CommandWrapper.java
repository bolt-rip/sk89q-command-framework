package com.sk89q.bungee.util;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;

public class CommandWrapper implements SimpleCommand {

    private String name;

    public CommandWrapper(CommandExecutor<CommandSource> executor, String commandName, String... aliases) {
        this.executor = executor;
        this.name = commandName;
    }

    @Override
    public void execute(Invocation invocation) {
        this.executor.onCommand(invocation.source(), this.name, invocation.arguments());
    }

    private final CommandExecutor<CommandSource> executor;
}
