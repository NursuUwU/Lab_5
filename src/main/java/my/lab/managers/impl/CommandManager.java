package my.lab.managers.impl;

import my.lab.managers.GettableCommands;
import my.lab.commands.Command;
import my.lab.commands.ParameterizedCommand;
import my.lab.commands.ParameterlessCommand;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CommandManager implements GettableCommands {
    private final Map<String, Command> commands;
    private final Queue<String> history = new LinkedList<>();

    public CommandManager(Map<String, Command> commands) {
        this.commands = commands;
    }

    /**
     * Метод добавляет команду в список доступных команд
     *
     * @param name    Это имя команды, добавляемой в список команд, по которой она будет вызываться пользователем
     * @param command Это объект команды, добавляемой в список команд
     */
    public void register(String name, Command command) {
        commands.put(name, command);
    }

    /**
     * Метод вызывает метод {@code public void execute(String[] args)}, переопределённый для каждой команды
     *
     * @param input Имя и аргументы вызываемой команды
     */
    public void executeCommand(String input) {
        if (input == null) {
            System.out.println("Ой, вы не ввели команду TwT");
            return;
        }
        String[] parts = input.split(" ");
        String commandName = parts[0];
        addToHistory(commandName);
        Command command = commands.get(commandName);
        if (command instanceof ParameterlessCommand) {
            ((ParameterlessCommand) command).execute();
        } else if (command instanceof ParameterizedCommand) {
            ((ParameterizedCommand) command).execute(parts);
        } else {
            System.out.println("Неизвестная команда: " + input);
        }
    }

    /**
     * Метод добавляет последнюю введённую команду в историю
     *
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

    /**
     * Стандартный геттер для коллекции команд
     *
     * @return Возвращает коллекцию команд
     */
    @Override
    public Map<String, Command> getCommands() {
        return commands;
    }
}
