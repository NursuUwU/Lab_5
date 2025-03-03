package commands;

import data.HumanBeing;

import java.util.LinkedHashSet;

public class RemoveGreaterCommand implements ParameterizedCommand{
    private final LinkedHashSet<HumanBeing> collection;
    public RemoveGreaterCommand(LinkedHashSet<HumanBeing> collection) {
        this.collection = collection;
    }
    @Override
    public String describe() {
        return "- remove_greater - удаляет все элементы с id выше заданного";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Ой, введите, пожалуйста, id `~`");
            return;
        }
        try {
            long id = Long.parseLong(args[1]);
            HumanBeing ref = collection.stream().filter(h -> h.getId() == id).findFirst().orElse(null);
            if (ref == null) {
                System.out.println("Ой, кажется такого элемента нет 0wo ");
                return;
            }
            collection.removeIf(h -> h.compareTo(ref) > 0);
            System.out.println("Все элементы с id выше " + id + " были удалены! >:3");
        } catch (NumberFormatException e) {
            System.out.println("Ой, id должен быть числом x~o");
        }
    }
}
