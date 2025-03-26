package my.lab.commands.impl;

import my.lab.commands.ParameterizedCommand;
import my.lab.managers.Saveable;

import java.io.IOException;

public class SaveCommand implements ParameterizedCommand {
    private Saveable saveable;

    public SaveCommand(Saveable saveable) {
        this.saveable = saveable;
    }

    @Override
    public String describe() {
        return "- save - сохраняет коллекцию в файл (введите *название файла*.json)";
    }

    /**
     * Метод сохраняет коллекцию в указанный файл
     *
     * @param args Ссылка на файл
     */
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Ой, вы не ввели название файла o~O");
            return;
        }
        String filePath = args[1];
        try {
            saveable.save(filePath);
            System.out.println("Коллекция успешно сохранена в файлик " + filePath + " ~^~");
        } catch (IOException e) {
            System.out.println("Ой, произошла ошибочка при попытке сохранить файл X~O");
        }
    }
}
