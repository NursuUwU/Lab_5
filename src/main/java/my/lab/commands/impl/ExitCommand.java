package my.lab.commands.impl;

import my.lab.commands.ParameterlessCommand;

public class ExitCommand implements ParameterlessCommand {
    @Override
    public String describe() {
        return "- exit";
    }

    /**
     * Метод завершает программу без ошибки
     */
    @Override
    public void execute() {
        System.out.println("До скорых встреч! Ow~");
        System.exit(0);
    }
}
