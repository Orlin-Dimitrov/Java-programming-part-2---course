/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import reference.domain.Person;

/**
 *
 * @author Dmitry
 */
public class PersonComparator implements Comparator<Person>{
    private Map<Person, Integer> peopleIdentities;

    public PersonComparator(Map peopleIdentities) {
        this.peopleIdentities = peopleIdentities;
    }
    
    @Override
    public int compare(Person o1, Person o2) {
        int p1 = peopleIdentities.get(o1);
        int p2 = peopleIdentities.get(o2);
        return p2 - p1;
    }
    
}
