
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Dictionary {
    private HashMap<String, String> map = new HashMap<String, String>();
    
    public void add(String word, String translation) {
        map.put(word, translation);
    }
    
    public String translate(String word) {
        return map.get(word);
    }
    
    public int amountOfWords() {
        return map.size();
    }
    
    public ArrayList<String> translationList() {
        ArrayList<String> list = new ArrayList<String>();
        for (String key : map.keySet()) {
            list.add(key + " = " + map.get(key));
        }
        return list;
    }
}
