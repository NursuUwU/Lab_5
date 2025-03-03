package commands;

import data.HumanBeing;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Optional;

public class MaxByHasToothpickCommand implements ParameterlessCommand {
    private final LinkedHashSet<HumanBeing> collection;
    public MaxByHasToothpickCommand(LinkedHashSet<HumanBeing> collection) {
        this.collection = collection;
    }

    @Override
    public String describe() {
        return "- max_by_has_toothpick - выводит элемент с наибольшим значением поля hasToothpick";
    }

    @Override
    public void execute() {
        Optional<HumanBeing> maxElement = collection.stream().max(Comparator.comparing(HumanBeing::isHasToothpick));
        maxElement.ifPresentOrElse(System.out::println, () -> System.out.println("Ой, коллекция пустая TwT"));
    }
}
