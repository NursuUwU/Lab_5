package my.lab.commands.impl;

import my.lab.commands.Command;
import my.lab.commands.ParameterlessCommand;
import my.lab.managers.GettableCommands;

import java.util.Map;

public class HelpCommand implements ParameterlessCommand {
    private final GettableCommands gettableCommands;

    public HelpCommand(GettableCommands gettableCommands) {
        this.gettableCommands = gettableCommands;
    }

    @Override
    public String describe() {
        return "- help";
    }

    /**
     * Выводит список доступных команд из коллекции
     */
    @Override
    public void execute() {
        System.out.println("Списочек доступных команд ~^~ :");
        for (Map.Entry<String, Command> entry : gettableCommands.getCommands().entrySet()) {
            System.out.println(entry.getValue().describe());
        }
    }
}
