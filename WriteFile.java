package GeekBrains.Java.Exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    StringBuilder output;
    String filename;

    public WriteFile(StringBuilder output, String filename) {
        this.output = output;
        this.filename = filename;
    }

    public void writeDataToFile() {

        try (FileWriter writer = new FileWriter(this.filename, true);) {
            writer.append(this.output);
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}
