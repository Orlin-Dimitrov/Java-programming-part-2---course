
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        File toRead = new File(file);
        Scanner reader = new Scanner(toRead);
        List<String> list = new ArrayList<String>();
        while(reader.hasNextLine()) {
            list.add(reader.nextLine());
        }
        return list;
    }

    public void save(String file, String text) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter writer = new FileWriter(file,  true);
        for(String line : texts) {
            writer.write(line + "\n");
        }
        writer.close();
    }
}
