package commands;
import data.HumanBeing;
import java.util.Collection;

public class InfoCommand implements ParameterlessCommand {
    private Collection<HumanBeing> collection;
    public InfoCommand(Collection<HumanBeing> collection) {
        this.collection = collection;
    }
    @Override
    public String describe() {
        return "- info - выводит информацию о коллекции (тип, количество элементов, дата последней инициализации)";
    }
    @Override
    public void execute() {
        System.out.println("Тип коллекции: " + collection.getClass());
        System.out.println("Количество элементов в коллекции: " + collection.size());
        System.out.println("Дата последней инициализации: " + new java.util.Date());
    }
}
