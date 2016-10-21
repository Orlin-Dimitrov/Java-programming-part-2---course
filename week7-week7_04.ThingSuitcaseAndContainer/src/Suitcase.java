
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class Suitcase {
    private int maxWeight;
    private ArrayList<Thing> things = new ArrayList<Thing>();

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
    }
    
    public int totalWeight() {
        int weightCount = 0;
        for (Thing item : things) {
            weightCount += item.getWeight();
        }
        return weightCount;
    }
    
    public void addThing(Thing thing) {
        int weight = totalWeight();
        weight += thing.getWeight();
        
        if (weight <= maxWeight) {
            things.add(thing);
        }
    }
    
    public void printThings() {
        for (Thing item : things) {
            System.out.println(item.toString());
        }
    }
    
    public Thing heaviestThing() {
        Thing heaviest = null;
        int max = 0;
        for (int i = 0; i < things.size(); i ++) {
            int temp = things.get(i).getWeight();
            if (temp > max) {
                max = temp;
                heaviest = things.get(i);
            }
        }
        return heaviest;
    }
    
    public String toString() {
        String word;
        int size = things.size();
        int weight = totalWeight();
        if (size == 0) {
            word = "empty ";
            return word + "(" + weight + " kg)";
        }
        else if (size == 1) {
            word = " thing ";
        }
        else {
            word = " things ";
        }
        return size + word + "(" + weight + " kg)";
    }
    
}
