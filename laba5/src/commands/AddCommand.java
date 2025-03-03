package commands;
import data.*;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class AddCommand extends AddElementService implements ParameterizedCommand {
    public AddCommand(LinkedHashSet<HumanBeing> collection) {
        super(collection);
    }
    @Override
    public String describe() {
        return "- add {element} (в качестве аргументов введите name, isRealHero (true/false), hasToothpick (true/false), impactSpeed)";
    }

    /**
     * Этот метод добавляет элемент, созданный методом createElement(String[] args)
     * в коллекцию LinkedHashSet<HumanBeing> collection
     * @param args Аргументы, передаваемые в метод createElement(String[] args)
     */
    @Override
    public void execute(String[] args) {
    HumanBeing human = createElement(args);
    collection.add(human);
    }

}
