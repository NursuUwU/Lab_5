package commands.realisations;

import commands.ints.ParameterizedCommand;
import data.HumanBeing;
import managers.ints.Creatable;
import managers.ints.GettableCollection;
import managers.ints.Removeable;


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
     * @param args id элемента и аргументы методов {@code public void createElement(String[] args)} и {@code public void removeElement(String[] args)}
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Пожалуйста, введите id O~O");
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
