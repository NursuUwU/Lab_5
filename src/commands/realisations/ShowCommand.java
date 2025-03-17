package commands.realisations;

import commands.ints.ParameterlessCommand;
import data.HumanBeing;
import managers.ints.GettableCollection;

public class ShowCommand implements ParameterlessCommand {
    private final GettableCollection gettableCollection;
    public ShowCommand(GettableCollection gettableCollection) {
        this.gettableCollection = gettableCollection;
    }
    @Override
    public String describe() {
        return "- show - выводит элементы коллекции";
    }

    /**
     * Метод выводит элементы коллекции со всеми полями
     */

    @Override
    public void execute() {
        if(!gettableCollection.getCollection().isEmpty()) {
            for (HumanBeing human: gettableCollection.getCollection()) {
                System.out.println(human + "\n");
            }
        } else {
            System.out.println("Коллекция пустая x~x");
        }
    }
}
