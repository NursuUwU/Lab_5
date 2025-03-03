package commands;

import data.HumanBeing;
import java.util.Collection;

public class ShowCommand implements ParameterlessCommand {
    private final Collection<HumanBeing> collection;
    public ShowCommand(Collection<HumanBeing> collection) {
        this.collection = collection;
    }
    @Override
    public String describe() {
        return "- show - выводит элементы коллекции";
    }

    @Override
    public void execute() {
        if(!collection.isEmpty()) {
            for (HumanBeing human: collection) {
                System.out.println(human + "\n");
            }
        } else {
            System.out.println("Коллекция пустая x~x");
        }
    }
}
