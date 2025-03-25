package my.lab.commands;

public interface ParameterlessCommand extends Command {
    /**
     * Метод исполняет команду без параметров.
     * Переопределён для каждой команды по-своему
     */
    void execute();
}
