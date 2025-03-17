package commands.ints;

public interface ParameterizedCommand extends Command{
    /**
     * Метод исполняет параметризованную команду.
     * Переопределён для каждой команды по-своему
     * @param args Аргументы команды
     */
    void execute(String[] args);

}
