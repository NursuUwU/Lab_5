package commands.realisations;
import commands.ints.ParameterizedCommand;
import data.*;
import managers.ints.Creatable;
import managers.ints.GettableCollection;

public class AddCommand implements ParameterizedCommand {
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
     * @param args Аргументы, передаваемые в метод createElement(String[] args)
     */
    @Override
    public void execute(String[] args) {
        if (args.length != 5) {
            System.out.println("Кажется вы ввели не 4 аргумента TwT");
            return;
        }
        HumanBeing human = creatable.createElement(args);
        gettableCollection.getCollection().add(human);


    }

}
