/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Dmitry
 */
public class Analysis {
    private File file;

    public Analysis(File file) {
        this.file = file;
    }
    
    public int lines() throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        int count = 0;
        while(reader.hasNextLine()) {
            reader.nextLine();
            count++;
        }
        return count;
    }
    
    public int characters() throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        int count = 0;
        while(reader.hasNextLine()) {
            String line = reader.nextLine();
            count += line.length() + 1;
        }
        return count;
    }
}
