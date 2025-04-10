package my.lab.commands.impl;

import my.lab.commands.ParameterlessCommand;
import my.lab.data.HumanBeing;
import my.lab.managers.Creatable;
import my.lab.managers.GettableCollection;


public class AddIfMinCommand implements ParameterlessCommand {
    private final Creatable creatable;
    private final GettableCollection gettableCollection;

    public AddIfMinCommand(Creatable creatable, GettableCollection gettableCollection) {
        this.creatable = creatable;
        this.gettableCollection = gettableCollection;
    }

    @Override
    public String describe() {
        return "- add_if_min - добавляет элемент, если его значение меньше всех элементов коллекции";
    }

    /**
     * Метод добавляет элемент в коллекцию только в случае, если он является минимальным
     */
    @Override
    public void execute() {
        HumanBeing human = creatable.createElement();
        HumanBeing minElement = gettableCollection.getCollection().stream().min(HumanBeing::compareTo).orElse(null);
        if (minElement == null || human.compareTo(minElement) < 0) {
            gettableCollection.getCollection().add(human);
            System.out.println("Элемент успешно добавлен! ~w~");
        } else {
            System.out.println("Элемент не является минимальным и не был добавлен в коллекцию TwT");

        }
    }
}
