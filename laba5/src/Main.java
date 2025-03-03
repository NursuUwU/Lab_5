import commands.*;
import data.HumanBeing;

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
        CommandManager manager = new CommandManager(commands);
        FileManager fileManager = new FileManager();
        LinkedHashSet<HumanBeing> collection = fileManager.loadCollection();
        Scanner scanner = new Scanner(System.in);
        manager.register("help", new HelpCommand(commands));
        manager.register("info", new InfoCommand(collection));
        manager.register("show", new ShowCommand(collection));
        manager.register("add", new AddCommand(collection));
        manager.register("update_by_id", new UpdateIdCommand(collection));
        manager.register("remove_by_id",new RemoveByIdCommand(collection));
        manager.register("clear", new ClearCommand(collection));
        manager.register("history", new HistoryCommand(manager));
        manager.register("save", new SaveCommand(collection));
        manager.register("execute_script", new ExecuteScriptCommand(manager));
        manager.register("exit", new ExitCommand());
        manager.register("add_if_min", new AddIfMinCommand(collection));
        manager.register("remove_greater", new RemoveGreaterCommand(collection));
        manager.register("remove_by_impact_speed", new RemoveByImpactSpeedCommand(collection));
        manager.register("max_by_has_toothpick", new MaxByHasToothpickCommand(collection));
        manager.register("print_field_ascending_impact_speed", new PrintFieldAscendingByImpactSpeedCommand(collection));
        System.out.println("Добро пожаловать -w- ! Введите команду (для просмотра досутпных комнад введите 'help'");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                input = null;
            }
            manager.executeCommand(input);
            if (input.equals("exit")) break;
        }
        scanner.close();
    }
}
