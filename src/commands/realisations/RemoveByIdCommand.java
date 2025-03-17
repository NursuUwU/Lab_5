package commands.realisations;

import commands.ints.ParameterizedCommand;
import managers.ints.Removeable;

public class RemoveByIdCommand implements ParameterizedCommand {
    private final Removeable removeable;
    public RemoveByIdCommand(Removeable removeable) {
     this.removeable = removeable;
    }
    @Override
    public String describe() {
        return "- remove_by_id - удаляет элемент с заданным id";
    }
    @Override
    public void execute(String[] args) {
        removeable.remove(args);
        System.out.println("Элемент был успешно удалён! Uw~");
    }
}
