package commands.realisations;

import commands.ints.ParameterizedCommand;
import managers.ints.ScriptExecutable;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ExecuteScriptCommand implements ParameterizedCommand {
    private final ScriptExecutable scriptExecutable;
    private final Set<String> executingScript = new HashSet<>();
    public ExecuteScriptCommand (ScriptExecutable scriptExecutable) {
        this.scriptExecutable = scriptExecutable;
    }
    @Override
    public String describe() {
        return "- execute_script (в качестве аргумента укажите ссылку на файл)";
    }
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Ой, введите, пожауйста, имя файла o~o");
            return;
        }
        String filePath = args[1];
        if(executingScript.contains(filePath)) {
            System.err.println("Ой, произошла рекурсия, завершаем метод X~x");
            return;
        }
        executingScript.add(filePath);
        try {
            scriptExecutable.executeScript(filePath);
        } catch (IOException e) {
            System.out.println("Ой, при попытке прочесть файл возникла ошибка! TwT");
        } finally {
            executingScript.remove(filePath);
        }
    }

}
