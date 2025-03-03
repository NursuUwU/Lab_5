package commands;

import data.HumanBeing;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class RemoveElementService {
    protected LinkedHashSet<HumanBeing> collection;
    public RemoveElementService(LinkedHashSet<HumanBeing> collection) {
        this.collection = collection;
    }
    public void removeElement(String[] args) {
        long id = 0;
        if (args.length < 2) {
            System.out.println("Ой, введите, пожалуйста, id Ono");
            return;
        }
        try {
            id = Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Ой, id должен быть числом x~O");
            return;
        }

        Iterator<HumanBeing> iterator = collection.iterator();
        HumanBeing oldElement = null;
        while (iterator.hasNext()) {
            HumanBeing human = iterator.next();
            if (human.getId() == id) {
                oldElement = human;
                iterator.remove();
                break;
            }
        }
        if (oldElement == null) {
            System.out.println("Элемент с данным id не найден 0~0");
        }
    }
}
