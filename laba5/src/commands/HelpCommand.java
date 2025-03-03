package commands;

import java.util.Map;

public class HelpCommand implements ParameterlessCommand {
    private final Map<String, Command> commands;
    public HelpCommand(Map<String, Command> commands) {
        this.commands = commands;
    }
    @Override
    public String describe() {
        return "- help";
    }

    @Override
    public void execute() {
        System.out.println("Списочек доступных команд ~^~ :");
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            System.out.println(entry.getValue().describe());
        }
    }
}
