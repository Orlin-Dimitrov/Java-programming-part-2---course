/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dmitry
 */
public class MindfulDictionary {
    private HashMap<String, String> dict = new HashMap<String, String>();
    private String file;

    public MindfulDictionary() {
    }

    public MindfulDictionary(String file) {
        this.file = file;
    }
    
    public void add(String word, String translation) {
        if(!dict.containsKey(word)) {
            dict.put(word, translation);
        }
    }
    
    public String translate(String word) {
        String translation = null;
        if(dict.containsKey(word)) {
            translation = dict.get(word);
        }
        else {
            for(Map.Entry<String, String> map : dict.entrySet()) {
                if(map.getValue().equals(word)) {
                    translation = map.getKey();
                    break;
                }
            }
        }
        return translation;
    }
    
    public void remove(String word) {
        if(dict.containsKey(word)) {
            dict.remove(word);
        }
        else {
            for(Map.Entry<String, String> map : dict.entrySet()) {
                if(map.getValue().equals(word)) {
                    dict.remove(map.getKey());
                    break;
                }
            }
        }
    }
    
    public boolean load() {
        Scanner reader = null;
        try {
            reader = new Scanner(new File(file));
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } finally {
            if(reader != null)
                reader.close();
        }
    }
    
    public boolean save() {
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File(file));
            for(Map.Entry<String, String> map : dict.entrySet()) {
                writer.write(map.getKey() + ":" + map.getValue() + "\n");
            }
            return true;
        } catch (IOException ex) {
            return false;
        } finally {
            if(writer != null)
                try {
                    writer.close();
            } catch (IOException ex) {
                //do moting
            }
        }
    }
    
}
