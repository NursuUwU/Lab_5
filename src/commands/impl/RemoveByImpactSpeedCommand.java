package commands.impl;

import commands.ParameterizedCommand;
import data.HumanBeing;
import managers.GettableCollection;

import java.util.Iterator;

public class RemoveByImpactSpeedCommand implements ParameterizedCommand {
    private final GettableCollection gettableCollection;
    public RemoveByImpactSpeedCommand(GettableCollection gettableCollection) {
        this.gettableCollection = gettableCollection;
    }
    @Override
    public String describe() {
        return "- remove_any_by_impact_speed - удаляет один элемент с данным значением скорости удара";
    }

    /**
     * Метод удаляет все элементы с заданной скоростью удара
     * @param args Скорость удара
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Oй, введите, пожалуйста, скорость удара O*o");
            return;
        }
        long impactSpeed = 0;
        boolean removed = false;
        try {
            impactSpeed = Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Ой, скорость удара должна быть числом o~X");
            return;
        }
        Iterator<HumanBeing> iterator = gettableCollection.getCollection().iterator();
        while (iterator.hasNext()) {
            HumanBeing human = iterator.next();
            if (impactSpeed == human.getImpactSpeed()) {
                iterator.remove();
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Ой, элемента с такой скоростью удара нет TwT");
        }
    }
}

