package managers;

import java.io.IOException;

public interface ScriptExecutable {
    void executeScript(String filePath) throws IOException;
}
