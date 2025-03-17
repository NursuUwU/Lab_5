package commands.realisations;

import commands.ints.ParameterlessCommand;
import data.HumanBeing;
import managers.ints.GettableCollection;

import java.util.Comparator;
import java.util.Optional;

public class MaxByHasToothpickCommand implements ParameterlessCommand {
    private final GettableCollection gettableCollection;
    public MaxByHasToothpickCommand(GettableCollection gettableCollection) {
        this.gettableCollection = gettableCollection;
    }

    @Override
    public String describe() {
        return "- max_by_has_toothpick - выводит элемент с наибольшим значением поля hasToothpick";
    }

    /**
     * Выводит элементы коллекции с максимальным значением hasToothpick
     */
    @Override
    public void execute() {
        Optional<HumanBeing> maxElement = gettableCollection.getCollection().stream()
                .max(Comparator.comparing(HumanBeing::isHasToothpick));
        maxElement.ifPresentOrElse(System.out::println,
                () -> System.out.println("Ой, коллекция пустая TwT"));
    }
}
