package commands;

import data.HumanBeing;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class UpdateIdCommand extends AddElementService implements ParameterizedCommand{
    private final RemoveElementService removeElementService;
    public UpdateIdCommand(LinkedHashSet<HumanBeing> collection) {
        super(collection);
        this.removeElementService = new RemoveElementService(collection);
    }
    @Override
    public String describe() {
        return "- update_by_id {element} (в качестве аргументов введите id элемента, который хотите заменить, а также аргументы нового элемента)";
    }
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Пожалуйста, введите id O~O");
            return;
        }
        try {
            long id = Long.parseLong(args[1]);
            removeElementService.removeElement(args);
            HumanBeing newElement = createElement(args);
            collection.add(newElement);
        } catch (NumberFormatException e) {
            System.out.println("Ой, id должен быть числом x~o");
        }

    }

}
