
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Changer {
    List<Change> listOfChanges = new ArrayList<Change>();
    
    public void addChange(Change change) {
        listOfChanges.add(change);
    }
    
    public String change(String characterString) {
        for (Change c : listOfChanges ) {
            characterString = c.change(characterString);
        }
        return characterString;
    }
}
