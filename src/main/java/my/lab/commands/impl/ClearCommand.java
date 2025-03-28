package my.lab.commands.impl;

import my.lab.commands.ParameterlessCommand;
import my.lab.managers.GettableCollection;


public class ClearCommand implements ParameterlessCommand {
    private final GettableCollection gettableCollection;

    public ClearCommand(GettableCollection gettableCollection) {
        this.gettableCollection = gettableCollection;
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
        gettableCollection.getCollection().clear();
        System.out.println("Коллекция была очищена! >:3");
    }
}
