package commands.realisations;

import commands.ints.ParameterlessCommand;
import data.HumanBeing;
import managers.ints.GettableCollection;

public class PrintFieldAscendingByImpactSpeedCommand implements ParameterlessCommand {
    private final GettableCollection gettableCollection;
    public PrintFieldAscendingByImpactSpeedCommand(GettableCollection gettableCollection) {
        this.gettableCollection = gettableCollection;
    }

    @Override
    public String describe() {
        return "- print_field_ascending_impact_speed - " +
                "выводит значения скорости удара в порядке возрастания";
    }

    /**
     * Метод выводит элементы коллекции, отсортированные по скорости удара
     * в возрастающем порядке
     */
    @Override
    public void execute() {
        if (gettableCollection.getCollection().isEmpty()) {
            System.out.println("Ой, коллекция пустая TwT");
            return;
        }
        gettableCollection.getCollection().stream().map(HumanBeing::getImpactSpeed)
                .sorted().forEach(System.out::println);
    }
}
