package commands;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import data.HumanBeing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;

public class FileManager {
    private final String filePath = System.getenv("FILE_PATH");
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public LinkedHashSet<HumanBeing> loadCollection() {
        LinkedHashSet<HumanBeing> collection = new LinkedHashSet<>();
        if (filePath == null || filePath.isEmpty()) {
            System.err.println("Ой, вы не задали путь к файлу в переменной окружения FILE_PATH O~x");
            return collection;
        }
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Такой файл не найден TwT");
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

}
