package my.lab.commands.impl;

import my.lab.commands.ParameterizedCommand;
import my.lab.data.HumanBeing;
import my.lab.managers.GettableCollection;


public class RemoveGreaterCommand implements ParameterizedCommand {
    private final GettableCollection gettableCollection;

    public RemoveGreaterCommand(GettableCollection gettableCollection) {
        this.gettableCollection = gettableCollection;
    }

    @Override
    public String describe() {
        return "- remove_greater - удаляет все элементы с id выше заданного";
    }

    /**
     * Метод удаляет все эелементы с id выше введённого
     *
     * @param args id элумента и аргументы метода
     *             {@code public void createElement(String[] args)}
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Ой, введите, пожалуйста, id `~`");
            return;
        }
        try {
            long id = Long.parseLong(args[1]);
            HumanBeing ref = gettableCollection.getCollection().stream()
                    .filter(h -> h.getId() == id).findFirst().orElse(null);
            if (ref == null) {
                System.out.println("Ой, кажется такого элемента нет 0wo ");
                return;
            }
            gettableCollection.getCollection().removeIf(h -> h.compareTo(ref) > 0);
            System.out.println("Все элементы с id выше " + id + " были удалены! >:3");
        } catch (NumberFormatException e) {
            System.out.println("Ой, id должен быть числом x~o");
        }
    }
}
