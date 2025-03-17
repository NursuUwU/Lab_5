package commands.realisations;
import commands.ints.ParameterlessCommand;
import managers.ints.GettableCollection;

public class InfoCommand implements ParameterlessCommand {
    private final GettableCollection gettableCollection;
    public InfoCommand(GettableCollection gettableCollection) {
        this.gettableCollection = gettableCollection;
    }
    @Override
    public String describe() {
        return "- info - выводит информацию о коллекции (тип, количество элементов, дата последней инициализации)";
    }
    @Override
    public void execute() {
        System.out.println("Тип коллекции: " + gettableCollection.getCollection().getClass());
        System.out.println("Количество элементов в коллекции: " + gettableCollection
                .getCollection().size());
        System.out.println("Дата последней инициализации: " + new java.util.Date());
    }
}
