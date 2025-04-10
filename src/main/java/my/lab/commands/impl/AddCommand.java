package my.lab.commands.impl;

import my.lab.commands.ParameterlessCommand;
import my.lab.data.HumanBeing;
import my.lab.managers.Creatable;
import my.lab.managers.GettableCollection;

public class AddCommand implements ParameterlessCommand {
    private final Creatable creatable;
    private final GettableCollection gettableCollection;

    public AddCommand(Creatable creatable, GettableCollection gettableCollection) {
        this.creatable = creatable;
        this.gettableCollection = gettableCollection;
    }

    @Override
    public String describe() {
        return "- add {element} (в качестве аргументов введите name, isRealHero (true/false), hasToothpick (true/false), impactSpeed)";
    }

    /**
     * Этот метод добавляет элемент, созданный методом createElement(String[] args)
     * в коллекцию {@code LinkedHashSet<HumanBeing>} collection
     */
    @Override
    public void execute() {
        HumanBeing human = creatable.createElement();
        gettableCollection.getCollection().add(human);
    }

}
