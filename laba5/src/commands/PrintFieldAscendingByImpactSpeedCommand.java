package commands;

import data.HumanBeing;

import java.util.LinkedHashSet;
import java.util.Optional;

public class PrintFieldAscendingByImpactSpeedCommand implements ParameterlessCommand{
    private final LinkedHashSet<HumanBeing> collection;
    public PrintFieldAscendingByImpactSpeedCommand(LinkedHashSet<HumanBeing> collection) {
        this.collection = collection;
    }

    @Override
    public String describe() {
        return "- print_field_ascending_impact_speed - выводит значения скорости удара в порядке возрастания";
    }

    @Override
    public void execute() {
        if (collection.isEmpty()) {
            System.out.println("Ой, коллекция пустая TwT");
            return;
        }
        collection.stream().map(HumanBeing::getImpactSpeed).sorted().forEach(System.out::println);
    }
}
