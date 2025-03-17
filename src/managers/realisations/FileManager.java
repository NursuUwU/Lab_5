package managers.realisations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import data.HumanBeing;
import managers.ints.GettableCollection;
import managers.ints.Saveable;
import managers.ints.ScriptExecutable;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class FileManager implements Saveable, ScriptExecutable {
    private final String filePath = System.getenv("FILE_PATH");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private GettableCollection gettableCollection;
    private CommandManager commandManager;
    public FileManager(GettableCollection gettableCollection, CommandManager commandManager) {
        this.gettableCollection = gettableCollection;
        this.commandManager = commandManager;
    }

    /**
     * Загружает коллекцию из файла, путь к которому задан переменной окружения
     * @return Возвращает коллекцию, хранящуюся в файле
     */
    public LinkedHashSet<HumanBeing> loadCollection() {
        LinkedHashSet<HumanBeing> collection = gettableCollection.getCollection();
        if  (filePath == null || filePath.isEmpty()) {
            System.err.println("Ой, вы не задали путь к файлу в переменной окружения FILE_PATH O~x");
            return collection;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Такой файл с коллекцией не найден TwT");
            return collection;
        }
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            Type collectionType = new TypeToken<LinkedHashSet<HumanBeing>>() {}.getType();
            collection = gson.fromJson(reader, collectionType);
            if (collection == null) {
                collection = new LinkedHashSet<>();
            }
            System.out.println("Коллекция успешно загружена! ~^~");
        } catch (IOException e) {
            System.err.println("Ой, не удалось прочитать файл O~x");
        }
        return collection;
    }
    /**
     * Метод сохраняет коллекцию в указанный файл
     * @param filePath Ссылка на файл
     */
    public void save(String filePath) throws IOException {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8)) {
            writer.write(gson.toJson(gettableCollection.getCollection()));
        }
    }

    /**
     * Выполняет скрипт из файла
     * @param filePath Путь к файлу
     */
    @Override
    public void executeScript(String filePath) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
             Scanner scanner = new Scanner(reader)) {
            System.out.println("Выполняю команды из файла " + filePath + " UwU :");
            while (scanner.hasNext()) {
                String command = scanner.nextLine();
                if (!command.isEmpty()) {
                    System.out.println("> " + command);
                    commandManager.executeCommand(command);
                }
            }
        }
    }

}
