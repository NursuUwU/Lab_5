package my.lab.commands;

public interface Command {
    /**
     * Выводит соответствующее описание команды (при вызове команды {@code help}).
     * Переопределён для каждой команды по-своему
     *
     * @return Описание команды
     */
    String describe();
}
