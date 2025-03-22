package managers;

import commands.Command;

import java.util.Map;

public interface GettableCommands {
    Map<String, Command> getCommands();
}
