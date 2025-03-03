package commands;

import data.HumanBeing;

import java.util.LinkedHashSet;

public class RemoveByIdCommand extends RemoveElementService implements ParameterizedCommand{
    public RemoveByIdCommand(LinkedHashSet<HumanBeing> collection) {
     super(collection);
    }
    @Override
    public String describe() {
        return "- remove_by_id - удаляет элемент с заданным id";
    }
    @Override
    public void execute(String[] args) {
        removeElement(args);
    }
}
