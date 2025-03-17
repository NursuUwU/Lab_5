package managers.ints;

import java.io.IOException;

public interface Saveable {
    void save(String filePath) throws IOException;
}
