
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
public class Container {
    private int maxWeight;
    private ArrayList<Suitcase> suitcases = new ArrayList<Suitcase>();

    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
    }
    
    public int totalWeight() {
        int weightCount = 0;
        for (Suitcase item : suitcases) {
            weightCount += item.totalWeight();
        }
        return weightCount;
    }
    
    public void addSuitcase(Suitcase suitcase) {
        int weight = totalWeight();
        weight += suitcase.totalWeight();
        
        if (weight <= maxWeight) {
            suitcases.add(suitcase);
        }
    }
    
    public void printThings() {
        for (Suitcase suitcase : suitcases) {
            suitcase.printThings();
        }
    }
    
    public String toString() {
        String word;
        int size = suitcases.size();
        int weight = totalWeight();
        if (size == 0) {
            word = "empty ";
            return word + "(" + weight + " kg)";
        }
        else if (size == 1) {
            word = " suitcase ";
        }
        else {
            word = " suitcases ";
        }
        return size + word + "(" + weight + " kg)";
    }
    
}
