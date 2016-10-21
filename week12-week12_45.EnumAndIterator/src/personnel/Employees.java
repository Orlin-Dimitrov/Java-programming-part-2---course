/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Dmitry
 */
public class Employees {
    private List<Person> persons;

    public Employees() {
        persons = new ArrayList<Person>();
    }
    
    public void add(Person person) {
        persons.add(person);
    }
    
    public void add(List<Person> persons) {
        for(Person p : persons) {
            this.persons.add(p);
        }
    }
        
    public void print() {
        Iterator<Person> iter = persons.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
    
    public void print(Education education) {
        Iterator<Person> iter = persons.iterator();
        while(iter.hasNext()) {
            Person temp = iter.next();
            if (temp.getEducation() == education) {
                System.out.println(temp);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> it = persons.iterator();
        while(it.hasNext()) {
            Person p = it.next();
            if(p.getEducation() == education) {
                it.remove();
            }
        }
    }
    
}
