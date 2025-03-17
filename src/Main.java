import commands.ints.Command;
import commands.realisations.*;
import data.HumanBeing;
import managers.realisations.CollectionManager;
import managers.realisations.CommandManager;
import managers.realisations.FileManager;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * Программа позволяет управлять коллекцией людей
 * @author Nursu!
 */
public class Main {
    public static void main(String[] args) {
        Map<String, Command> commands = new HashMap<>();
        CommandManager commandManager = new CommandManager(commands);

        LinkedHashSet<HumanBeing> collection = new LinkedHashSet<>();
        CollectionManager collectionManager = new CollectionManager(collection);

        FileManager fileManager = new FileManager(collectionManager, commandManager);
        collectionManager.setCollection(fileManager.loadCollection());

        Scanner scanner = new Scanner(System.in);
        commandManager.register("help",
                new HelpCommand(commandManager));
        commandManager.register("info",
                new InfoCommand(collectionManager));
        commandManager.register("show",
                new ShowCommand(collectionManager));
        commandManager.register("add",
                new AddCommand(collectionManager, collectionManager));
        commandManager.register("update_by_id",
                new UpdateIdCommand(collectionManager, collectionManager, collectionManager));
        commandManager.register("remove_by_id",
                new RemoveByIdCommand(collectionManager));
        commandManager.register("clear",
                new ClearCommand(collectionManager));
        commandManager.register("history",
                new HistoryCommand(commandManager));
        commandManager.register("save",
                new SaveCommand(fileManager));
        commandManager.register("execute_script",
                new ExecuteScriptCommand(fileManager));
        commandManager.register("exit",
                new ExitCommand());
        commandManager.register("add_if_min",
                new AddIfMinCommand(collectionManager, collectionManager));
        commandManager.register("remove_greater",
                new RemoveGreaterCommand(collectionManager));
        commandManager.register("remove_by_impact_speed",
                new RemoveByImpactSpeedCommand(collectionManager));
        commandManager.register("max_by_has_toothpick",
                new MaxByHasToothpickCommand(collectionManager));
        commandManager.register("print_field_ascending_impact_speed",
                new PrintFieldAscendingByImpactSpeedCommand(collectionManager));
        System.out.println("Добро пожаловать -w- ! " +
                "Введите команду (для просмотра досутпных комнад введите 'help'");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                input = null;
            }
            commandManager.executeCommand(input);
            if (input != null && input.equals("exit")) break;
        }
        scanner.close();
    }
}
