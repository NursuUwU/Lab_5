package my.lab.managers;

import my.lab.commands.Command;

import java.util.Map;

public interface GettableCommands {
    Map<String, Command> getCommands();
}
