package commands;

import data.HumanBeing;

import java.util.LinkedHashSet;

public class ClearCommand implements ParameterlessCommand{
    private final LinkedHashSet<HumanBeing> collection;
    public ClearCommand(LinkedHashSet<HumanBeing> collection) {
        this.collection = collection;
    }
    @Override
    public String describe() {
        return "- clear - очищает коллекцию";
    }

    /**
     * Метод удаляет все элементы коллекции
     */
    @Override
    public void execute() {
        collection.clear();
        System.out.println("Коллекция была очищена! >:3");
    }
}
