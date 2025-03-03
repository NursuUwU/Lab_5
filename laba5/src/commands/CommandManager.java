package commands;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CommandManager {
    private final Map<String, Command> commands;
    private final Queue<String> history = new LinkedList<>();
    public CommandManager(Map<String, Command> commands) {
        this.commands = commands;

    }

    /**
     * Метод добавляет команду в список доступных команд
     * @param name Это имя команды, добавляемой в список команд, по которой она будет вызываться пользователем
     * @param command Это объект команды, добавляемой в список команд
     */
    public void register(String name, Command command) {
        commands.put(name, command);
    }

    /**
     * Метод вызывает метод {@code public void execute(String[] args)}, переопределённый для каждой команды
     * @param input Имя и аргументы вызываемой команды
     */
    public void executeCommand(String input) {
        String[] parts = input.split(" ");
        String commandName = parts[0];
        addToHistory(commandName);
        Command command = commands.get(commandName);
        if (command instanceof ParameterlessCommand && parts.length == 1) {
            ((ParameterlessCommand) command).execute();
        } else if (command instanceof  ParameterizedCommand) {
            ((ParameterizedCommand) command).execute(parts);
        }
        else {
            System.err.println("Неизвестная команда: " + input);
        }
    }

    /**
     * Метод добавляет последнюю введённую команду в историю
     * @param command Имя введённой команды
     */
    public void addToHistory(String command) {
        if (history.size() >= 5) {
            history.poll();
        }
        history.offer(command);
    }

    /**
     * Метод выводит последние пять введённых команд
     */
    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("Вы ещё не ввели ни одной команды ~");
        }
        for (String cmd : history) {
            System.out.println(cmd);
        }
    }
}
