package managers.ints;

import commands.ints.Command;

import java.util.Map;

public interface GettableCommands {
    Map<String, Command> getCommands();
}
