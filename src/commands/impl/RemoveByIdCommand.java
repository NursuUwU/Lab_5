package commands.impl;

import commands.ParameterizedCommand;
import exceptions.NoSuchIdException;
import managers.Removeable;

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
        if (args.length < 2) {
            System.out.println("Ой, введите, пожалуйста, id Ono");
            return;
        }
        try {
            removeable.remove(args);
        } catch (NumberFormatException e) {
            System.out.println("Ой, id должен быть числом x~O");
            return;
        } catch (NoSuchIdException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Элемент был успешно удалён! Uw~");
    }
}
