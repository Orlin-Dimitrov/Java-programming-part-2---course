
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Printer {
    private String fileName;
    private Scanner reader;
    private File f;

    public Printer(String fileName) throws Exception {
        this.fileName = fileName;
        f = new File(this.fileName);
        
    }
    
    public void printLinesWhichContain(String word) throws FileNotFoundException {
        reader = new Scanner(f);
        if (word.equals("")) {
            while(reader.hasNextLine())
                System.out.println(reader.nextLine());
        }
        else {
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                if(line.indexOf(word) != -1)
                    System.out.println(line);
            }
        }
    }
}
