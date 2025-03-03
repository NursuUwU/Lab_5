package commands;

import data.HumanBeing;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;

public class SaveCommand implements ParameterizedCommand{
    private final LinkedHashSet<HumanBeing> collection;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public SaveCommand(LinkedHashSet<HumanBeing> collection) {
        this.collection = collection;
    }
    @Override
    public String describe() {
        return "- save - сохраняет коллекцию в файл (введите *название файла*.json)";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Ой, вы не ввели название файла o~O");
            return;
        }
        String filePath = args[1];
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8)) {
            writer.write(gson.toJson(collection));
            System.out.println("Коллекция успешно сохранена в " + filePath + " ! ~w~");
        } catch (IOException e) {
            System.err.println("Не удалось соханить файл TwT");
        }

    }
}
