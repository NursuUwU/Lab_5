package commands;

import data.HumanBeing;

import java.util.LinkedHashSet;

public class AddIfMinCommand extends AddElementService implements ParameterizedCommand {
   public AddIfMinCommand(LinkedHashSet<HumanBeing> collection) {
       super(collection);
   }
    @Override
    public String describe() {
        return "- add_if_min - добавляет элемент, если его значение меньше всех элементов коллекции";
    }

    /**
     * Метод добавляет элемент в коллекцию только в случае, если он является минимальным
     * @param args Аргументы, передаваемые в метод createElement(String[] args)
     */
    @Override
    public void execute(String[] args) {
        HumanBeing human = createElement(args);
        HumanBeing minElement = collection.stream().min(HumanBeing::compareTo).orElse(null);
        if (minElement == null || human.compareTo(minElement) < 0) {
            collection.add(human);
            System.out.println("Элемент успешно добавлен! ~w~");
        } else {
            System.out.println("Элемент не является минимальным и не был добавлен в коллекцию TwT");

        }
    }
}
