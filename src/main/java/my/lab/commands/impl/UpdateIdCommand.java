package my.lab.commands.impl;

import my.lab.commands.ParameterizedCommand;
import my.lab.data.HumanBeing;
import my.lab.managers.Creatable;
import my.lab.managers.GettableCollection;
import my.lab.managers.Removeable;


public class UpdateIdCommand implements ParameterizedCommand {
    private final Creatable creatable;
    private final Removeable removeable;
    private final GettableCollection gettableCollection;

    public UpdateIdCommand(Creatable creatable, Removeable removeable,
                           GettableCollection gettableCollection) {
        this.removeable = removeable;
        this.creatable = creatable;
        this.gettableCollection = gettableCollection;
    }

    @Override
    public String describe() {
        return "- update_by_id {element} (в качестве аргументов введите id элемента, который хотите заменить, а также аргументы нового элемента)";
    }

    /**
     * Метод удаляет элемент с введённым id и добавляет вместо него элемент с заданными параметрами
     *
     * @param args id элемента и аргументы методов {@code public void createElement(String[] args)} и {@code public void removeElement(String[] args)}
     */
    @Override
    public void execute(String[] args) {
        if (args.length != 6) {
            System.out.println("Пожалуйста, введите все аргументы O~O");
            return;
        }
        try {
            long id = Long.parseLong(args[1]);
            removeable.remove(args);
            HumanBeing newElement = creatable.createElement(args);
            gettableCollection.getCollection().add(newElement);
        } catch (NumberFormatException e) {
            System.out.println("Ой, id должен быть числом x~o");
        }

    }

}
