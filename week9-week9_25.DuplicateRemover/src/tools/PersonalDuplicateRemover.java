/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Dmitry
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    private int count = 0;
    private Set<String> set = new HashSet<String>();
    
    @Override
    public void add(String characterString) {
        if(this.set.contains(characterString)) {
            count++;
        }
        else {
            set.add(characterString);
        }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return count;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.set;
    }

    @Override
    public void empty() {
        this.set.clear();
        count = 0;
    }
    
}
