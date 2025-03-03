package commands;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ExecuteScriptCommand implements ParameterizedCommand{
    private final CommandManager manager;
    public ExecuteScriptCommand (CommandManager manager) {
        this.manager = manager;
    }
    @Override
    public String describe() {
        return "- execute_script (в качестве аргумента укажите ссылку на файл)";
    }

    /**
     *
     * @param args Аргументы команды
     */
    @Override
    public void execute(String[] args) {
        /*
        String filePath = System.getenv("SCRIPT_FILE_NAME");
        if(filePath == null || filePath.isEmpty()) {
            System.out.println("Ой, задайте, пожалуйста, значение переменной окружения SCRIPT_FILE_NAME X~O");
            return;
        }
        File file = new File(filePath);
        if (!file.exists() || file.isFile()) {
            System.out.println("Ой, файл " + filePath + " не найден TwT");
        }
        */
        if (args.length < 2) {
            System.out.println("Ой, введите, пожауйста, имя файла o~o");
            return;
        }
        String filePath = args[1];
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
        Scanner scanner = new Scanner(reader)) {
            System.out.println("Выполняю команды из файла " + filePath + " UwU :");
            while (scanner.hasNext()) {
                String command = scanner.nextLine();
                if (!command.isEmpty()) {
                    System.out.println("> " + command);
                    manager.executeCommand(command);
                }
            }
        } catch (IOException e) {
            System.err.println("Ой, при попытке прочесть файл возникла ошибка! TwT");
        }


    }
}
