package my.lab.commands.impl;

import my.lab.commands.ParameterlessCommand;
import my.lab.managers.impl.CommandManager;

public class HistoryCommand implements ParameterlessCommand {
    private final CommandManager manager;

    public HistoryCommand(CommandManager manager) {
        this.manager = manager;
    }

    @Override
    public String describe() {
        return "- history - выводит последние 5 команд";
    }

    @Override
    public void execute() {
        System.out.println("История команд (последние 5) :");
        manager.printHistory();

    }
}
